package marker

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.util.stream.Collectors
import kotlin.streams.toList

enum class Type{
    SOLVE, TRY;
}

fun main(args: Array<String>){

    println(findAndMark("shouwn", "5585", "2739"))
}

fun findAndMark(id: String, target: String, subTarget: String?): String{
    return "${String.format("%-10s", id)}: ${mark(findNumbersMapById(id), target, subTarget)}"
}

fun mark(map: HashMap<Type, Set<String>>, target: String, subTarget: String?): String =
        when {
            target in map[Type.SOLVE]!! -> "O"
            subTarget in map[Type.SOLVE]!! -> "$subTarget"
            target in map[Type.TRY]!! -> "시도"
            subTarget in map[Type.TRY]!! -> "${subTarget}시도"
            else -> "X"
        }


fun findNumbersMapById(id: String): HashMap<Type, Set<String>> { // 404 핸들링 안 만듬
    val elements =
            Jsoup.connect("https://www.acmicpc.net/user/$id").get()
                    .getElementsByClass("panel panel-default")

    fun Element.numbers(): Set<String> =
            Jsoup.parse(this.html()).getElementsByClass("problem_number").stream()
                    .map(Element::text)
                    .collect(Collectors.toSet())

    return hashMapOf(Type.SOLVE to elements[0].numbers(), Type.TRY to elements[1].numbers())
}