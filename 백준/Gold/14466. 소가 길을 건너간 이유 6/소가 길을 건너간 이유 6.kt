package data_24_12_15

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k, r) = readLine().split(" ").map { it.toInt() }

    val existLoad = Array(n * n) {
        BooleanArray(n * n)
    }
    repeat(r) {
        val (s1, s2, e1, e2) = readLine().split(" ").map { it.toInt() - 1 }
        val num1 = s1 * n + s2
        val num2 = e1 * n + e2
        existLoad[num1][num2] = true
        existLoad[num2][num1] = true
    }

    val cowInMap = Array(n) {
        BooleanArray(n)
    }
    repeat(k) {
        val (y, x) = readLine().split(" ").map { it.toInt() - 1 }
        cowInMap[y][x] = true
    }

    val farm = Farm(n, k, cowInMap, existLoad)
    print(farm.getNoPairCowCnt())
}

private class Farm(
    initSize: Int,
    private val cowNum: Int,
    private val cowInMap: Array<BooleanArray>,
    private val existLoad: Array<BooleanArray>,
) {
    private val size = initSize
    private val map = Array<Land>(size * size) {
        Land(it, it / size, it % size)
    }
    private val dy = listOf(-1, 0, 1, 0)
    private val dx = listOf(0, 1, 0, -1)
    fun getNoPairCowCnt(): Int {
        var pair = combination2(cowNum)
        val isVisited = BooleanArray(size * size)
        for (i in 0..<size * size) {
            if (!isVisited[i]) {
                val q = ArrayDeque<Land>()
                q.add(map[i])
                isVisited[i] = true
                var cowNum = if (cowInMap[map[i].y][map[i].x]) 1 else 0
                while (q.isNotEmpty()) {
                    val (num, y, x) = q.removeLast()
                    for (k in 0..3) {
                        val ny = y + dy[k]
                        val nx = x + dx[k]
                        val nextNum = ny * size + nx
                        if (ny in 0..<size && nx in 0..<size) {
                            if (!existLoad[num][nextNum] && !isVisited[nextNum]) {
                                q.add(map[nextNum])
                                isVisited[nextNum] = true
                                cowNum += if (cowInMap[ny][nx]) 1 else 0
                            }
                        }
                    }
                }
                pair -= combination2(cowNum)
            }
        }
        return pair
    }

    fun combination2(n: Int): Int {
        if (n < 2) {
            return 0
        }
        var result = 1
        for (i in n-1..n) {
            result *= i
        }

        return result / 2
    }

    private data class Land(
        val num: Int,
        val y: Int,
        val x: Int
    )
}