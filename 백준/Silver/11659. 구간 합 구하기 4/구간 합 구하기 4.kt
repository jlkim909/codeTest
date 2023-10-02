package DP

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var t1 = StringTokenizer(br.readLine())
    val n = t1.nextToken().toInt()
    val m = t1.nextToken().toInt()
    t1 = StringTokenizer(br.readLine())
    val numArr = Array(n){
        t1.nextToken().toInt()
    }
    val d = Array(100_000){
        0
    }
    d[0] = numArr[0]
    for(i in 1 until n){
        d[i] = numArr[i] + d[i-1]
    }
    repeat(m){
        t1 = StringTokenizer(br.readLine())
        val i = t1.nextToken().toInt() - 1
        val j = t1.nextToken().toInt() - 1
        bw.write("${d[j] - d[i] + numArr[i]}\n")
    }
    bw.flush()
    bw.close()
}
