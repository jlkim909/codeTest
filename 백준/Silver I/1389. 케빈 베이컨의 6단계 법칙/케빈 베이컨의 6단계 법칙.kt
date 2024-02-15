package bfs

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val dist = Array(n + 1) {
        IntArray(n + 1) {
            1_000_000_000
        }
    }

    repeat(m) {
        val (from, to) = readLine().split(" ").map { it.toInt() }
        dist[from][to] = 1
        dist[to][from] = 1
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j]
                }
            }
        }
    }

    var result = 1
    var min = Int.MAX_VALUE
    for (i in 1..n) {
        var sum = 0
        for (j in 1..n) {
            sum += dist[i][j]
        }
        if (min > sum) {
            min = sum
            result = i
        }
    }

    print(result)
}