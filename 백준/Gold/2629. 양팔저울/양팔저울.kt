package date_25_01_05

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val weights = readLine().split(" ").map { it.toInt() }

    val d = Array(n) {
        mutableSetOf<Int>()
    }

    d[0].add(weights[0])

    for (i in 1..<n) {
        d[i].addAll(d[i - 1])
        d[i - 1].forEach {
            d[i].add(it + weights[i])
            d[i].add(abs(it - weights[i]))
        }
        d[i].add(weights[i])
    }

    readLine()
    readLine().split(" ").forEach {
        if(d[n - 1].contains(it.toInt())){
            print("Y ")
        }else{
            print("N ")
        }
    }
}