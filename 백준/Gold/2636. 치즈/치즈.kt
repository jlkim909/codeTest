package date_25_01_05


fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = List(n) {
        readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val dy = listOf(-1, 0, 1, 0)
    val dx = listOf(0, 1, 0, -1)
    var time = 0
    var lastMeltCount = 0
    while (true) {
        var meltCount = 0
        val isVisited = List(n) {
            BooleanArray(m)
        }

        for (i in 0..<n) {
            if (i != 0 && i != n - 1) continue
            for (j in 0..<m) {
                if (j != 0 && j != m - 1) continue
                if (isVisited[i][j]) continue
                if (map[i][j] == 0) {
                    isVisited[i][j] = true
                    val dq = ArrayDeque<Pair<Int, Int>>()
                    dq.add(Pair(i, j))
                    while (dq.isNotEmpty()) {
                        val (y, x) = dq.removeFirst()
                        for (k in 0..3) {
                            val ny = y + dy[k]
                            val nx = x + dx[k]
                            if (ny in 0..<n && nx in 0..<m) {
                                if (!isVisited[ny][nx]) {
                                    isVisited[ny][nx] = true
                                    if (map[ny][nx] != 0) {
                                        map[ny][nx] = 0
                                        meltCount += 1
                                    } else {
                                        dq.add(Pair(ny, nx))
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (meltCount == 0) {
            break
        }
        lastMeltCount = meltCount
        time += 1
    }

    print("$time\n$lastMeltCount")
}