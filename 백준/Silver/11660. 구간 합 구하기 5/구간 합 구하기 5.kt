package dp

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() = with(System.`in`.bufferedReader()){
    val (n, m) = readLine().split(" ").map{it.toInt()}
    val table = Array(n){
        val l = readLine().split(" ").map{it.toInt()}
        IntArray(n){
            l[it]
        }
    }

    val d = Array(n+1){
        IntArray(n+1){
            0
        }
    }

    d[1][1] = table[0][0]
    for(i in 2..n){
        d[1][i] = d[1][i-1] + table[0][i-1]
    }

    for(i in 2..n){
        d[i][1] = d[i-1][1] + table[i-1][0]
    }

    for(i in 2..n){
        for(j in 2..n){
            d[i][j] = d[i][j-1] + d[i-1][j] - d[i-1][j-1] + table[i-1][j-1]
        }
    }

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(m){
        val (y1, x1, y2, x2) = readLine().split(" ").map{it.toInt()}
        bw.write("${d[y2][x2] - d[y1-1][x2] - d[y2][x1-1] + d[y1-1][x1-1]}\n")
    }
    bw.flush()
    bw.close()
}