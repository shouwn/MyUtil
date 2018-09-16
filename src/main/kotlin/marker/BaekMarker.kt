package marker

import com.google.common.util.concurrent.ThreadFactoryBuilder
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.stream.Collectors
import kotlin.streams.toList
import java.nio.file.Files.size
import java.util.concurrent.Executors
import java.util.concurrent.Executor
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.ExecutorService
import java.util.concurrent.ScheduledExecutorService
import java.util.function.Supplier

enum class Type{
    SOLVE, TRY;
}

fun main(args: Array<String>){
//    val target = args[0]
//    val subTarget = args[1]
    val target = "5585"
    val subTarget = "2739"

    val start = System.currentTimeMillis()
    println(LocalDateTime.now())

//    File("./list.txt").bufferedReader().readLines().toObservable()
//            .subscribeOn(Schedulers.io())
//            .map { CompletableFuture.supplyAsync { findAndMark(it, target, subTarget) } }
//            .observeOn(Schedulers.io())
//            .map { it.get() }
//            .subscribe {println(it)}

    File("./list.txt").bufferedReader().readLines().parallelStream()
            .map { CompletableFuture.supplyAsync { findAndMark(it, target, subTarget) } }
            .map { it.get() }
            .forEach {println(it)}

    Thread.sleep(10000)

    println(System.currentTimeMillis() - start)
}

fun findAndMark(id: String, target: String, subTarget: String?): String{
    return "$id\t${mark(findNumbersMapById(id), target, subTarget)}"
}

fun mark(map: Map<Type, Set<String>>, target: String, subTarget: String?): String =
        when {
            target in map[Type.SOLVE]!! -> "O"
            subTarget in map[Type.SOLVE]!! -> "$subTarget"
            target in map[Type.TRY]!! -> "시도"
            subTarget in map[Type.TRY]!! -> "${subTarget}시도"
            else -> "X"
        }


fun findNumbersMapById(id: String): Map<Type, Set<String>> { // 404 핸들링 안 만듬
    println("Thread: ${Thread.currentThread().name}   $id start")

    val elements =
            Jsoup.connect("https://www.acmicpc.net/user/$id").get()
                    .getElementsByClass("panel panel-default")

    fun Element.numbers(): Set<String> =
            Jsoup.parse(this.html()).getElementsByClass("problem_number").stream()
                    .map(Element::text)
                    .collect(Collectors.toSet())

    println("Thread: ${Thread.currentThread().name}   $id end")

    return hashMapOf(Type.SOLVE to elements[0].numbers(), Type.TRY to elements[1].numbers())
}