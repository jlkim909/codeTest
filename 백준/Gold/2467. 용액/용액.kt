package date_24_11_13

import kotlin.math.abs

private var absoluteValue = Int.MAX_VALUE
private var result = Pair(0, 0)
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val liquids = readLine().split(" ").map { it.toInt() }
    liquids.forEach {
        binarySearch(it, liquids)
    }
    print("${result.first} ${result.second}")
}

private fun binarySearch(target: Int, list: List<Int>) {
    var start = 0
    var end = list.size - 1
    while (start <= end) {
        val mid = (start + end) / 2
        if (target == list[start] || target == list[mid]) {
            start += 1
            continue
        }

        if (target == list[end]) {
            end -= 1
            continue
        }
        val sumLiquid = abs(target + list[mid])
        if (absoluteValue > sumLiquid) {
            absoluteValue = sumLiquid
            result = Pair(target, list[mid])
        }
        if (target + list[mid] > 0) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
}