package bfs

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val campus = Array(n) {
        readLine()
    }

    val dy = arrayOf(-1, 0, 1, 0)
    val dx = arrayOf(0, 1, 0, -1)

    val q = ArrayDeque<Pair<Int, Int>>()
    val isVisited = Array(n) {
        BooleanArray(m)
    }

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (campus[i][j] == 'I') {
                q.add(Pair(i, j))
                isVisited[i][j] = true
            }
        }
    }

    var result = 0
    while (q.isNotEmpty()) {
        val (y, x) = q.removeFirst()
        if (campus[y][x] == 'P') {
            result++
        }
        for (i in 0..3) {
            val ny = y + dy[i]
            val nx = x + dx[i]
            if (ny in 0..<n && nx in 0..<m) {
                if (campus[ny][nx] != 'X' && !isVisited[ny][nx]) {
                    q.add(Pair(ny, nx))
                    isVisited[ny][nx] = true
                }
            }
        }
    }

    print(if (result == 0) "TT" else result)
}