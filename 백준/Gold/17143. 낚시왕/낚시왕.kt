package date_24_9_2

private enum class DIRECTION {
    UP,
    DOWN,
    LEFT,
    RIGHT,
}

private var r = 0
private var c = 0
private var m = 0
fun main() = with(System.`in`.bufferedReader()) {
    val inp = readLine().split(" ").map { it.toInt() }

    r = inp[0]
    c = inp[1]
    m = inp[2]

    val ocean = Ocean()
    repeat(m) {
        val (y, x, speed, d, size) = readLine().split(" ").map { it.toInt() }
        val dir = when (d) {
            1 -> DIRECTION.UP
            2 -> DIRECTION.DOWN
            3 -> DIRECTION.RIGHT
            else -> DIRECTION.LEFT
        }

        ocean.addSharks(y - 1, x - 1, speed, dir, size)
    }

    for (i in 0..<c) {
        ocean.fishing(i)
        ocean.sharksMove()
    }

    print(ocean.totalHuntSize)
}

private class Ocean() {
    var totalHuntSize = 0
    private var map = Array(r) {
        Array<Shark?>(c) {
            null
        }
    }

    fun fishing(cx: Int) {
        for (i in 0..<r) {
            if (map[i][cx] != null) {
                totalHuntSize += map[i][cx]!!.size
                map[i][cx] = null
                break
            }
        }
    }

    fun addSharks(y: Int, x: Int, speed: Int, dir: DIRECTION, size: Int) {
        map[y][x] = Shark(speed, dir, size)
    }

    fun sharksMove() {
        val newMap = Array(r) {
            Array<Shark?>(c) {
                null
            }
        }
        for (i in 0..<r) {
            for (j in 0..<c) {
                if (map[i][j] == null) {
                    continue
                }
                val (speed, dir, size) = map[i][j]!!
                var ny = i
                var nx = j
                var nd = dir
                val moveCnt = when (nd) {
                    DIRECTION.UP,
                    DIRECTION.DOWN -> speed % (2 * (r - 1))

                    else -> speed % (2 * (c - 1))
                }

                repeat(moveCnt) {
                    when (nd) {
                        DIRECTION.UP -> {
                            if (ny == 0) {
                                ny += 1
                                nd = DIRECTION.DOWN
                            } else {
                                ny -= 1
                            }
                        }

                        DIRECTION.DOWN -> {
                            if (ny == r - 1) {
                                ny -= 1
                                nd = DIRECTION.UP
                            } else {
                                ny += 1
                            }
                        }

                        DIRECTION.LEFT -> {
                            if (nx == 0) {
                                nx += 1
                                nd = DIRECTION.RIGHT
                            } else {
                                nx -= 1
                            }
                        }

                        DIRECTION.RIGHT -> {
                            if (nx == c - 1) {
                                nx -= 1
                                nd = DIRECTION.LEFT
                            } else {
                                nx += 1
                            }
                        }
                    }
                }
                val shark = newMap[ny][nx]
                if (shark == null || shark.size < size) {
                    newMap[ny][nx] = Shark(speed, nd, size)
                }
            }
        }
        map = newMap
    }
}

private data class Shark(
    val speed: Int,
    val dir: DIRECTION,
    val size: Int,
)