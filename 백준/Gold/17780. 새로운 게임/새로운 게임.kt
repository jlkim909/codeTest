package data_24_12_15

private val dy = listOf(0, 0, -1, 1)
private val dx = listOf(1, -1, 0, 0)
fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val map = Array(n + 2) {
        IntArray(n + 2) { 2 }
    }
    repeat(n) { y ->
        val inp = readLine().split(" ").map { it.toInt() }
        for (i in 1..n) {
            map[y + 1][i] = inp[i - 1]
        }
    }


    val horses = List(k) { num ->
        val (y, x, dir) = readLine().split(" ").map { it.toInt() }
        Horse(num, y, x, dir - 1)
    }

    val newGame = NewGame(map, horses)
    print(newGame.getTime())
}

private class NewGame(
    private val map: Array<IntArray>,
    private val horses: List<Horse>
) {
    private val mapSize = map.size
    private val horsesInMap = Array(mapSize) {
        Array(mapSize) {
            mutableListOf<Int>()
        }
    }

    init {
        horses.forEach {
            horsesInMap[it.y][it.x].add(it.num)
        }
    }

    fun getTime(): Int {
        var time = 1
        var moveNum = 0
        while (time <= 1000) {
            if (moveNum >= horses.size) {
                moveNum = 0
                time += 1
            }
            val ch = horses[moveNum]
            val (y, x) = ch.getPosition()
            if (horsesInMap[y][x].first() != moveNum) {
                moveNum += 1
                continue
            }
            val (ny, nx) = ch.getNextPosition()
            val idx = horsesInMap[y][x].indexOf(moveNum)

            when (map[ny][nx]) {
                0 -> {
                    moveNum += 1
                    val moveList = horsesInMap[y][x].subList(idx, horsesInMap[y][x].size)
                    horsesInMap[y][x] = horsesInMap[y][x].subList(0, idx)
                    for (num in moveList) {
                        horses[num].move(ch.dir)
                        horsesInMap[ny][nx].add(num)
                    }
                }

                1 -> {
                    moveNum += 1
                    val moveList = horsesInMap[y][x].subList(idx, horsesInMap[y][x].size)
                    horsesInMap[y][x] = horsesInMap[y][x].subList(0, idx)
                    for (num in moveList.reversed()) {
                        horses[num].move(ch.dir)
                        horsesInMap[ny][nx].add(num)
                    }
                }

                else -> {
                    ch.reverseDir()
                    val (ny2, nx2) = ch.getNextPosition()
                    if (map[ny2][nx2] == 2) {
                        moveNum += 1
                    }
                }
            }

            if (horsesInMap[ny][nx].size >= 4) {
                break
            }
        }
        return if (time > 1000) -1 else time
    }
}

private class Horse(
    val num: Int,
    initY: Int,
    initX: Int,
    initDir: Int,
) {
    var y = initY
    var x = initX
    var dir = initDir
    fun move(d: Int) {
        y += dy[d]
        x += dx[d]
    }

    fun reverseDir() {
        dir = when (dir) {
            0 -> 1
            1 -> 0
            2 -> 3
            else -> 2
        }
    }

    fun getPosition(): Position {
        return Position(y, x)
    }

    fun getDirChar(): String {
        return when (dir) {
            0 -> "→"
            1 -> "←"
            2 -> "↑"
            else -> "↓"
        }
    }

    fun getNextPosition(): Position {
        return Position(y + dy[dir], x + dx[dir])
    }
}

private data class Position(
    val y: Int,
    val x: Int,
)