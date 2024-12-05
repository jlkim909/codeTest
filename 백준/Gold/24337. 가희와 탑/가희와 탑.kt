package date_24_12_9

fun main() = with(System.`in`.bufferedReader()) {
    var (n, a, b) = readLine().split(" ").map { it.toInt() }
    val buildings = mutableListOf<Int>()
    if (a >= b) {
        repeat(a) {
            buildings.add(it + 1)
        }
        b -= 1
        a = 0
    } else {
        repeat(b) {
            buildings.add(b - it)
        }
        a -= 1
        b = 0
    }

    if (a > 0) {
        repeat(a) {
            buildings.add(0, a - it)
        }
    }

    if (b > 0) {
        repeat(b) {
            buildings.add(b - it)
        }
    }

    if (buildings.size > n) {
        print(-1)
    } else {
        var previousHeight = 1
        for (i in buildings.indices) {
            if (previousHeight >= buildings[i]) {
                repeat(n - buildings.size) {
                    buildings.add(i, 1)
                }
                break
            }
            previousHeight = buildings[i]
        }
        buildings.forEach {
            print("$it ")
        }
    }
}