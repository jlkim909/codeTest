package all

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val dy = arrayOf(0, 0, -1, -1, -1, 0, 1, 1, 1)
    val dx = arrayOf(0, -1, -1, 0, 1, 1, 1, 0, -1)

    val ddy = arrayOf(-1, -1, 1, 1)
    val ddx = arrayOf(-1, 1, 1, -1)
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n + 1) {
        Array(n + 1) {
            0
        }
    }

    repeat(n) { r ->
        val l = readLine().split(" ").map { it.toInt() }
        for (i in 0..<n) {
            map[r + 1][i + 1] = l[i]
        }
    }

    var cloud = mutableListOf<Pair<Int, Int>>()
    cloud.add(Pair(n, 1))
    cloud.add(Pair(n, 2))
    cloud.add(Pair(n - 1, 1))
    cloud.add(Pair(n - 1, 2))

    repeat(m) {
        val (d, s) = readLine().split(" ").map { it.toInt() }
        val upSpot = mutableListOf<Pair<Int, Int>>()
        val isVisited = Array(n + 1) {
            BooleanArray(n + 1) {
                false
            }
        }
        while (cloud.isNotEmpty()) {
            val (y, x) = cloud.removeFirst()
            var ny = y + dy[d] * (s % n)
            var nx = x + dx[d] * (s % n)
            if (ny <= 0) {
                ny += n
            } else if (ny > n) {
                ny -= n
            }
            if (nx <= 0) {
                nx += n
            } else if (nx > n) {
                nx -= n
            }
            isVisited[ny][nx] = true
            map[ny][nx]++
            upSpot.add(Pair(ny, nx))
        }
        while (upSpot.isNotEmpty()) {
            val (y, x) = upSpot.removeFirst()
            for (i in 0..3) {
                val ny = y + ddy[i]
                val nx = x + ddx[i]
                if (ny in 1..n && nx in 1..n) {
                    if (map[ny][nx] > 0) {
                        map[y][x]++
                    }
                }
            }
        }
        for (i in 1..n) {
            for (j in 1..n) {
                if (map[i][j] >= 2 && !isVisited[i][j]) {
                    cloud.add(Pair(i, j))
                    map[i][j] -= 2
                }
            }
        }
    }

    var result = 0
    for (i in 1..n) {
        for (j in 1..n) {
            result += map[i][j]
        }
    }

    print(result)
}