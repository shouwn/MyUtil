package main.reader

import jdk.internal.util.xml.impl.Input
import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>){
    print(System.`in`.bufferedReader().use {
        readLine()
    })
}