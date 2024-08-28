package date_24_9_2

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val liquids = readLine().split(" ").map { it.toInt() }.sorted()
    var result = Pair(liquids[0], liquids[n - 1])

    var minValue = abs(liquids[0] + liquids[n-1])
    var check = false
    for (i in 0..<n) {
        if(check){
            break
        }
        var start = i + 1
        var end = n - 1

        while (start <= end) {
            val mid = (start + end) / 2
            val v = liquids[i] + liquids[mid]
            if (abs(minValue) > abs(v)) {
                minValue = abs(v)
                result = Pair(liquids[i], liquids[mid])
            }

            if (v < 0) {
                start = mid + 1
            } else if (v > 0) {
                end = mid - 1
            } else {
                check = true
                break
            }
        }
    }

    if(result.first > result.second){
        print("${result.second} ${result.first}")
    }else{
        print("${result.first} ${result.second}")
    }
}
