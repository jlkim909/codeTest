package DP

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private val d = Array(31){
    Array(31){
        -1L
    }
}

fun main() = with(System.`in`.bufferedReader()){
    val t = readLine().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(t){
        val s = readLine().split(" ").map{it.toInt()}
        bw.write("${dp(s[0], s[1])}\n")
    }
    bw.flush()
    bw.close()
}

private fun dp(n: Int, m: Int): Long {
    if(n == 0) return 0
    if (n == m) return 1
    if (n == 1) return m.toLong()
    if (d[n][m] != -1L) return d[n][m]
    d[n][m] = dp(n, m - 1) + dp(n - 1, m - 1)
    return d[n][m]
}