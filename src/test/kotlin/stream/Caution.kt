package stream

import java.io.File

fun main(args: Array<String>){

    println("read lines()")
    File("./list.txt").bufferedReader().lines().parallel()
            .map { Thread.currentThread().name }
            .map { "$it -> ${Thread.currentThread().name}" }
            .parallel()
            .forEach { println(it) }

    println("\nread list to stream")
    File("./list.txt").bufferedReader().readLines().stream().parallel()
            .map { Thread.currentThread().name }
            .map { "$it -> ${Thread.currentThread().name}" }
            .forEach { println(it) }
}