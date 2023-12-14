package Greedy

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() = with(System.`in`.bufferedReader()){
    val testCase = readLine().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    data class Worker(val s1:Int, val s2:Int)
    repeat(testCase){
        val n = readLine().toInt()
        val worker = Array(n){
            val (s1, s2) = readLine().split(" ").map{it.toInt()}
            Worker(s1, s2)
        }

        worker.sortBy{it.s1}

        var ts2 = worker[0].s2
        var result = 1
        for(i in 1 until n){
            if(ts2 > worker[i].s2){
                ts2 = worker[i].s2
                result++
            }
        }
        bw.write("$result\n")
    }
    bw.flush()
    bw.close()
}