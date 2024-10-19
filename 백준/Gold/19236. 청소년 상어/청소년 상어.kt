package date_24_10_21

fun main() = with(System.`in`.bufferedReader()) {
    val map = Array(4) {
        Array<Fish?>(4) {
            null
        }
    }
    repeat(4) { row ->
        val inp = readLine().split(" ").map { it.toInt() }
        for (i in 0..7 step 2) {
            map[row][i / 2] = Fish(inp[i], inp[i + 1] - 1)
        }
    }

    val sea = Sea()
    print(sea.getMaxEat(map))
}

private class Sea {
    private val dy = listOf(-1, -1, 0, 1, 1, 1, 0, -1)
    private val dx = listOf(0, -1, -1, -1, 0, 1, 1, 1)

    fun getMaxEat(map: Array<Array<Fish?>>): Int {
        val firstEatenFish = map[0][0]!!
        map[0][0] = null
        val shark = Shark(0, 0, firstEatenFish.dir)

        return turn(shark, firstEatenFish.num, map)
    }

    fun turn(
        shark: Shark,
        score: Int,
        map: Array<Array<Fish?>>,
    ): Int {
        val newMap = fishMove(shark, map)
        val nextSharkPositions = getSharkNextPositions(newMap, shark)
        if (nextSharkPositions.isEmpty()) {
            return score
        }
        var maxScore = 0
        for (nextPosition in nextSharkPositions) {
            val (ny, nx) = nextPosition
            val eatenFish = newMap[ny][nx]!!
            newMap[ny][nx] = null
            val newShark = shark.copy(y = ny, x = nx, dir = eatenFish.dir)
            maxScore = maxOf(maxScore, turn(newShark, score + eatenFish.num, newMap))
            newMap[ny][nx] = eatenFish
        }

        return maxScore
    }

    fun fishMove(shark: Shark, map: Array<Array<Fish?>>): Array<Array<Fish?>> {
        val newMap = Array(4) { i ->
            Array(4) { j ->
                map[i][j]
            }
        }

        val isVisited = BooleanArray(17)
        for (k in 1..16) {
            for (i in 0..3) {
                for (j in 0..3) {
                    if (isVisited[k]) continue
                    if (newMap[i][j] != null && newMap[i][j]!!.num == k) {
                        val movingFish = newMap[i][j]!!
                        for (d in 0..7) {
                            val nd = (movingFish.dir + d) % 8
                            val ny = i + dy[nd]
                            val nx = j + dx[nd]
                            if (canMoveFish(ny, nx, shark)) {
                                val temp = newMap[ny][nx]
                                newMap[ny][nx] = movingFish.copy(dir = nd)
                                newMap[i][j] = temp
                                isVisited[k] = true
                                break
                            }
                        }
                    }
                }
            }
        }

        return newMap
    }

    private fun inMap(y: Int, x: Int): Boolean =
        (y in 0..3 && x in 0..3)

    fun getSharkNextPositions(map: Array<Array<Fish?>>, shark: Shark): List<Pair<Int, Int>> {
        val positions = mutableListOf<Pair<Int, Int>>()
        for (k in 1..3) {
            val (y, x, dir) = shark
            val ny = y + k * dy[dir]
            val nx = x + k * dx[dir]
            if (inMap(ny, nx) && map[ny][nx] != null) {
                positions.add(Pair(ny, nx))
            }
        }
        return positions
    }

    fun canMoveFish(y: Int, x: Int, shark: Shark): Boolean {
        return inMap(y, x) && !(shark.y == y && shark.x == x)
    }
}


private data class Fish(val num: Int, val dir: Int)

private data class Shark(val y: Int, val x: Int, val dir: Int)
