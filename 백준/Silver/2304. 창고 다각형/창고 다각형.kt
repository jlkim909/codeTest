package all

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    data class Stick(var x:Int, var h:Int)
    val n = readLine().toInt()
    val sticks = mutableListOf<Stick>()

    var start = 10000
    var end = 0

    repeat(n) {
        val (x, h) = readLine().split(" ").map { it.toInt() }
        sticks.add(Stick(x, h))
        sticks.add(Stick(x + 1, h))
    }

    sticks.sortBy { (x, _) -> x }

    var result = 0
    while (sticks.isNotEmpty()) {
        val left = sticks.first()
        val right = sticks.last()
        val h = minOf(left.h, right.h)
        result += (right.x-left.x) * h
        sticks.removeIf { s -> s.h <= h }
        sticks.forEach { s ->
            s.h -= h
        }
    }

    print(result)
}