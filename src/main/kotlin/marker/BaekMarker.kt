package marker

import com.google.common.util.concurrent.ThreadFactoryBuilder
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.toFlowable
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
    val target = "10871"
    val subTarget = ""

    val start = System.currentTimeMillis()
    println(LocalDateTime.now())

//    File("./list.txt").bufferedReader().readLines().parallelStream()
//            .map { findAndMark(it, target, subTarget) }
//            .forEach {println(it)}

    val map = hashMapOf<String, String>()

    val studentList = File("./list_python.txt").bufferedReader().readLines()

    studentList.toFlowable()
            .flatMap { Flowable.just(it)
                    .observeOn(Schedulers.io())
                    .map { Pair(it, findAndMark(it, target, subTarget)) } }
            .observeOn(Schedulers.io())
            .blockingSubscribe { map[it.first] = it.second }

    studentList.stream()
            .map { "$it\t${map[it]}" }
            .forEach { println(it) }

    println(System.currentTimeMillis() - start)
}

fun findAndMark(id: String, target: String, subTarget: String?): String{
    return "${mark(findNumbersMapById(id), target, subTarget)}"
}

fun mark(map: Map<Type, Set<String>>, target: String, subTarget: String?): String =
        when {
            target in map[Type.SOLVE]!! -> "O"
            subTarget in map[Type.SOLVE]!! -> "$subTarget"
            target in map[Type.TRY]!! -> "시도"
            subTarget in map[Type.TRY]!! -> "${subTarget}시도"
            else -> "X"
        }


fun findNumbersMapById(id: String): Map<Type, Set<String>> {
    val url = "https://www.acmicpc.net/user/$id"
    val elements: Elements
    try {
        elements =
                Jsoup.connect(url).get()
                        .getElementsByClass("panel panel-default")
    }catch (e: Exception) {
        return hashMapOf(Type.SOLVE to setOf(), Type.TRY to setOf())
    }

    fun Element.numbers(): Set<String> =
            Jsoup.parse(this.html()).getElementsByClass("problem_number").stream()
                    .map(Element::text)
                    .collect(Collectors.toSet())

    return hashMapOf(Type.SOLVE to elements[0].numbers(), Type.TRY to elements[1].numbers())
}