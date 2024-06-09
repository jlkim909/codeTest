package all

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val bees = IntArray(2 * m - 1) { 1 }

    repeat(n) {
        val (zero, one, two) =
            readLine().split(" ").map { it.toInt() }
        var k = zero
        repeat(one){
            bees[k++] += 1
        }

        repeat(two){
            bees[k++] += 2
        }
    }

    val beesList = Array(m){
        IntArray(m)
    }

    for(i in 0..<m){
        beesList[i][0] = bees[m-i-1]
    }

    for(i in 0..<m){
        for(j in 1..<m){
            beesList[i][j] = bees[m+j-1]
        }
    }

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    for(i in 0..<m){
        for(j in 0..<m){
            bw.write("${beesList[i][j]} ")
        }
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}