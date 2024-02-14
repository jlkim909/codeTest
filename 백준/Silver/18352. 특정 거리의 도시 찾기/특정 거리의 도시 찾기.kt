package bfs

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k, x) = readLine().split(" ").map { it.toInt() }
    val city = Array(n + 1) {
        mutableListOf<Int>()
    }
    repeat(m) {
        val (s, e) = readLine().split(" ").map { it.toInt() }
        city[s].add(e)
    }
    val q = ArrayDeque<Pair<Int, Int>>()
    val isVisited = BooleanArray(n + 1)
    q.add(Pair(x, 0))
    isVisited[x] = true

    val result = mutableListOf<Int>()
    while (q.isNotEmpty()) {
        val (c, d) = q.removeFirst()
        if (d == k) {
            result.add(c)
            continue
        }
        for (i in city[c]) {
            if (!isVisited[i]) {
                isVisited[i] = true
                q.add(Pair(i, d + 1))
            }
        }
    }


    if (result.size == 0) {
        println(-1)
    } else {
        result.sort()
        result.forEach {
            println(it)
        }
    }
}