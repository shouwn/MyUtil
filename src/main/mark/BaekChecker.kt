package main.mark

import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset
import java.io.InputStreamReader
import java.io.BufferedReader
import jdk.nashorn.internal.runtime.ScriptingFunctions.readLine
import java.util.stream.Stream


fun main(args: Array<String>){
    print(request("shouwn"))
}

fun request(id: String): String{
    val con: HttpURLConnection =
            URL("https://www.acmicpc.net/user/$id").openConnection() as HttpURLConnection
    con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11")
    con.requestMethod = "GET"
    con.connectTimeout = 5000
    con.readTimeout = 5000

    con.connect()

    val status: Int = con.responseCode

    var br = InputStreamReader(con.inputStream, Charset.forName("UTF-8")).buffered()

    val sb = StringBuilder()

    br.lines().forEach { sb.append(it) }

    br.close()
    con.disconnect()

    return sb.toString()
}
