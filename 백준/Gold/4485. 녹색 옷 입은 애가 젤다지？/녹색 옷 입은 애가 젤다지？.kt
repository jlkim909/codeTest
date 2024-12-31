package date_25_01_05

fun main() = with(System.`in`.bufferedReader()) {
    val dy = listOf(-1, 0, 1, 0)
    val dx = listOf(0, 1, 0, -1)
    val bw = System.out.bufferedWriter()
    var k = 1
    while (true) {
        val n = readLine().toInt()
        if (n == 0) {
            break
        }
        val map = List(n) {
            readLine().split(" ").map { it.toInt() }
        }
        val costMap = Array(n) {
            IntArray(n) { -1 }
        }

        costMap[0][0] = map[0][0]
        val dq = ArrayDeque<Pair<Int, Int>>()
        dq.add(Pair(0, 0))

        while (dq.isNotEmpty()) {
            val (y, x) = dq.removeFirst()
            for (i in 0..3) {
                val ny = y + dy[i]
                val nx = x + dx[i]
                if (ny in 0..<n && nx in 0..<n) {
                    val nextCost = map[ny][nx] + costMap[y][x]
                    if (costMap[ny][nx] == -1 || costMap[ny][nx] > nextCost) {
                        costMap[ny][nx] = nextCost
                        dq.add(Pair(ny, nx))
                    }
                }
            }
        }

        bw.write("Problem ${k++}: ${costMap[n - 1][n - 1]}\n")
    }
    bw.flush()
    bw.close()
}