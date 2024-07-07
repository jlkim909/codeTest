package start

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, l) = readLine().split(" ").map { it.toInt() }

    val restAreas = mutableListOf<Int>()
    restAreas.add(0)
    restAreas.add(l)
    if (n > 0) {
        readLine().split(" ").map {
            restAreas.add(it.toInt())
        }
    }
    restAreas.sort()

    val newList = mutableListOf<Int>()

    for (i in 1..<restAreas.size) {
        newList.add(restAreas[i] - restAreas[i - 1])
    }

    newList.sort()

    var result = newList.last()
    var end = l - 1
    var start = 0

    while (start <= end) {
        val mid = (start + end) / 2
        if (mid == 0) {
            start += 1
            continue
        }
        var cnt = 0
        for (num in newList) {
            if (num > mid) {
                cnt += if (num % mid == 0) {
                    num / mid - 1
                } else {
                    num / mid
                }
            }
        }

        if (cnt <= m) {
            end = mid - 1
            result = minOf(result, mid)
        } else {
            start = mid + 1
        }
    }
    print(result)
}