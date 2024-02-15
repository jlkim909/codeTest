package bfs

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() = with(System.`in`.bufferedReader()){
    val (n, k) = readLine().split(" ").map{it.toInt()}
    val inf = 1_000_000_000
    val dist = Array(n+1){
        IntArray(n+1){
            inf
        }
    }

    repeat(k){
        val (from, to) = readLine().split(" ").map{it.toInt()}
        dist[from][to] = 1
    }

    for(t in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if(dist[i][j] > dist[i][t] + dist[t][j]){
                    dist[i][j] = dist[i][t] + dist[t][j]
                }
            }
        }
    }

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(readLine().toInt()){
        val (from, to) = readLine().split(" ").map{it.toInt()}
        if(dist[from][to] != inf){
            bw.write("-1\n")
        }else{
            if(dist[to][from] == inf){
                bw.write("0\n")
            }else{
                bw.write("1\n")
            }
        }
    }

    bw.flush()
    bw.close()
}