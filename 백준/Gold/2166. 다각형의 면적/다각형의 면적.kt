package date_24_7_29

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val area = Array(n) {
        val (x, y) = readLine().split(" ").map { it.toLong() }
        Pair(x, y)
    }
    var result = 0.0
    for (i in 0..<n) {
        result += area[i].first * area[(i + 1)%n].second
    }

    for (i in 0..<n) {
        result -= area[(i+1)%n].first * area[i].second
    }

    println(String.format("%.1f", abs(result/2)))
}