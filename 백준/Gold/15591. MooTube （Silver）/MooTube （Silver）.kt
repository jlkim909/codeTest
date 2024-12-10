package data_24_12_15

fun main() = with(System.`in`.bufferedReader()) {
    val (n, q) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) {
        IntArray(n + 1)
    }

    val nodes = Array(n + 1) {
        mutableListOf<Int>()
    }

    repeat(n - 1) {
        val (n1, n2, r) = readLine().split(" ").map { it.toInt() }
        graph[n1][n2] = r
        graph[n2][n1] = r
        nodes[n1].add(n2)
        nodes[n2].add(n1)
    }

    for (i in 1..n) {
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.add(Pair(i, Int.MAX_VALUE))
        val isVisited = BooleanArray(n + 1)
        isVisited[i] = true
        while (queue.isNotEmpty()) {
            val (node, distance) = queue.removeLast()
            graph[i][node] = distance
            for (next in nodes[node]) {
                if (isVisited[next]) continue
                isVisited[next] = true
                queue.add(Pair(next, minOf(distance, graph[node][next])))
            }
        }
    }

    val bw = System.out.bufferedWriter()
    repeat(q) {
        val (k, node) = readLine().split(" ").map { it.toInt() }
        var cnt = 0
        for (i in 1..n) {
            if (node == i) continue
            if (graph[node][i] >= k) {
                cnt += 1
            }
        }
        bw.write("$cnt\n")
    }
    bw.flush()
    bw.close()
}