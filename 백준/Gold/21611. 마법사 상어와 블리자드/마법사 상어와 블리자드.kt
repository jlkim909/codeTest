package date_24_10_21

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) {
        val row = readLine().split(" ").map { it.toInt() }
        IntArray(n) { i ->
            row[i]
        }
    }

    val sharkWizard = SharkWizard(map)
    repeat(m) {
        val (dir, distance) = readLine().split(" ").map { it.toInt() }
        sharkWizard.blizzard(dir, distance)
    }

    print(sharkWizard.score)
}

private class SharkWizard(
    private val map: Array<IntArray>
) {
    private val dy = listOf(0, -1, 0, 1)
    private val dx = listOf(1, 0, -1, 0)
    private var beads = mutableListOf<Int>()
    private val mapSize = map.size
    private val mapNumber = Array(mapSize) {
        IntArray(mapSize)
    }

    init {
        var sy = mapSize / 2
        var sx = mapSize / 2 - 1
        beads.add(map[sy][sx])
        mapNumber[sy][sx] = 0
        sy += 1
        mapNumber[sy][sx] = 1
        beads.add(map[sy][sx])
        var dir = 0
        var k = 2
        var isEnd = false
        var number = 2
        while (!isEnd) {
            repeat(k) {
                sy += dy[dir]
                sx += dx[dir]
                if (sy in 0..<mapSize && sx in 0..<mapSize) {
                    val type = map[sy][sx]
                    beads.add(type)
                    mapNumber[sy][sx] = number++
                } else {
                    isEnd = true
                    return@repeat
                }
            }
            dir = (dir + 1) % 4
            if (dir % 2 == 0) {
                k += 1
            }
        }
    }

    var score = 0
        private set

    fun blizzard(dir: Int, distance: Int) {
        val bDir = getBlizzardDir(dir)
        var sy = mapSize / 2 + distance * dy[bDir]
        var sx = mapSize / 2 + distance * dx[bDir]
        repeat(distance) {
            val removeNumber = mapNumber[sy][sx]
            if (removeNumber in beads.indices) {
                beads.removeAt(removeNumber)
            }
            sy -= dy[bDir]
            sx -= dx[bDir]
        }

        beads.removeAll { it == 0 }

        while (true) {
            if (!boomBeads()) {
                break
            }
        }
        changeBeads()
    }

    private fun boomBeads(): Boolean {
        var k = 0
        var isBoom = false
        while (k < beads.size) {
            val type = beads[k]
            var cnt = 1

            while (k + cnt < beads.size && beads[k + cnt] == type) {
                cnt += 1
            }

            if (cnt >= 4) {
                beads.subList(k, k + cnt).clear()
                score += type * cnt
                isBoom = true
            } else {
                k += cnt
            }
        }
        return isBoom
    }

    private fun changeBeads() {
        val newBeads = mutableListOf<Int>()
        var k = 0
        while (k < beads.size) {
            val type = beads[k]
            var cnt = 1

            while (k + cnt < beads.size && beads[k + cnt] == type) {
                cnt += 1
            }

            newBeads.add(cnt)
            newBeads.add(type)
            k += cnt
        }

        beads = newBeads.take(mapSize * mapSize - 1).toMutableList()
    }

    private fun getBlizzardDir(dir: Int): Int {
        return when (dir) {
            1 -> 1
            2 -> 3
            3 -> 2
            else -> 0
        }
    }
}