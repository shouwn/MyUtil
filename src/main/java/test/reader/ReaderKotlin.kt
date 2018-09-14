package test.reader

fun main(args: Array<String>){
    print(System.`in`.bufferedReader().use {
        readLine()
    })
}