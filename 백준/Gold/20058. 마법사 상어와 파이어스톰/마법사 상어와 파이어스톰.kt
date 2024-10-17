package date_24_10_21

fun main() = with(System.`in`.bufferedReader()) {
    val (n, _) = readLine().split(" ").map { it.toInt() }
    val mapSize = 1.shl(n)
    val map = Array(mapSize) { IntArray(mapSize) }
    repeat(mapSize) { i ->
        readLine().split(" ").mapIndexed { j, value ->
            map[i][j] = value.toInt()
        }
    }
    val wizard = Wizard(map)
    readLine().split(" ").map {
        wizard.magic(it.toInt())
    }

    println(wizard.getIceAmount())
    print(wizard.getBigIceSize())
}

private class Wizard(
    initialMap: Array<IntArray>,
) {
    var map = initialMap
    val mapSize = map.size

    private val dy = listOf(-1, 0, 1, 0)
    private val dx = listOf(0, 1, 0, -1)
    fun magic(l: Int) {
        if (l > 0) {
            rotate(l)
        }
        meltIce()
    }

    fun getIceAmount(): Int {
        var result = 0
        for (i in 0..<mapSize) {
            for (j in 0..<mapSize) {
                result += map[i][j]
            }
        }

        return result
    }

    fun getBigIceSize(): Int {
        var result = 0
        val isVisited = Array(mapSize) { i ->
            BooleanArray(mapSize) { j ->
                map[i][j] == 0
            }
        }

        for (i in 0..<mapSize) {
            for (j in 0..<mapSize) {
                if (isVisited[i][j]) continue
                val dq = ArrayDeque<Pair<Int, Int>>()
                var cnt = 0
                dq.add(Pair(i, j))
                isVisited[i][j] = true
                while (dq.isNotEmpty()) {
                    val (y, x) = dq.removeFirst()
                    cnt += 1
                    for (k in 0..3) {
                        val ny = y + dy[k]
                        val nx = x + dx[k]
                        if (inMap(ny, nx) && !isVisited[ny][nx]) {
                            isVisited[ny][nx] = true
                            dq.add(Pair(ny, nx))
                        }
                    }
                }
                if (result < cnt) {
                    result = cnt
                }
            }
        }

        return result
    }

    private fun inMap(y: Int, x: Int) = y in 0..<mapSize && x in 0..<mapSize
    private fun rotate(l: Int) {
        val tempMap = Array(mapSize) {
            IntArray(mapSize)
        }
        val range = 1.shl(l)
        var sy = 0
        var sx = 0
        while (sy < mapSize) {
            for (i in 0..<range) {
                for (j in 0..<range) {
                    tempMap[i + sy][j + sx] = map[sy + range - j - 1][i + sx]
                }
            }
            sx += range
            if (sx >= mapSize) {
                sx = 0
                sy += range
            }
        }

        map = tempMap
    }

    private fun meltIce() {
        val tempMap = Array(mapSize) {
            IntArray(mapSize)
        }
        for (i in 0..<mapSize) {
            for (j in 0..<mapSize) {
                if (map[i][j] == 0) {
                    continue
                }
                var cnt = 0
                for (k in 0..3) {
                    val ny = i + dy[k]
                    val nx = j + dx[k]
                    if (inMap(ny, nx)) {
                        if (map[ny][nx] != 0) {
                            cnt += 1
                        }
                    }
                }
                if (cnt < 3) {
                    tempMap[i][j] = map[i][j] - 1
                } else {
                    tempMap[i][j] = map[i][j]
                }
            }
        }

        map = tempMap
    }
}