package binarySearch

fun main() = with(System.`in`.bufferedReader()) {
    val dy = arrayOf(-1, 0, 1, 0)
    val dx = arrayOf(0, 1, 0, -1)

    data class P(val y: Int, val x: Int)
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val mine = Array(n) {
        val l = readLine().split(" ").map { it.toInt() }
        IntArray(m) {
            l[it]
        }
    }

    var s = 1
    var e = 1_000_001
    var result = 1_000_001
    while (s <= e) {
        val mid = (s + e) / 2
        val dq = ArrayDeque<P>()
        var sum = 0
        val isVisited = Array(n) {
            BooleanArray(m) {
                false
            }
        }
        for (i in 0..<m) {
            if (mid >= mine[0][i]) {
                isVisited[0][i] = true
                dq.add(P(0, i))
                sum++
            }
        }
        for (j in 1..<n) {
            if (mid >= mine[j][0]) {
                isVisited[j][0] = true
                dq.add(P(j, 0))
                sum++
            }
            if (mid >= mine[j][m - 1]) {
                isVisited[j][m - 1] = true
                dq.add(P(j, m - 1))
                sum++
            }
        }

        while (dq.isNotEmpty()) {
            val (y, x) = dq.removeFirst()
            for (q in 0..3) {
                val ny = y + dy[q]
                val nx = x + dx[q]
                if (ny in 0..<n && nx in 0..<m && !isVisited[ny][nx]) {
                    if (mine[ny][nx] <= mid) {
                        isVisited[ny][nx] = true
                        dq.add(P(ny, nx))
                        sum++
                    }
                }
            }
        }

        if (sum < k) {
            s = mid + 1
        } else {
            e = mid - 1
            result = minOf(result, mid)
        }
    }

    print(result)
}
