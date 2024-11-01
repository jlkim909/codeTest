package date_24_10_21

// n x n 격자
// m 상어의 마리 수
// k 냄새 지속 시간
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) {
        readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val dirs = readLine().split(" ").map { it.toInt() - 1 }
    val priorityDirs = List(m) {
        List(4) {
            readLine().split(" ").map { it.toInt() - 1 }
        }
    }

    val sea = AdultSea(map, dirs, priorityDirs, k)
    print(sea.getTimeOfAloneShark())
}

private class AdultSea(
    initMap: Array<IntArray>,
    initSharksDir: List<Int>,
    initSharksPriorityDir: List<List<List<Int>>>,
    initDuration: Int,
) {
    private val map = initMap
    private val mapSize = initMap.size
    private val range = 0..<mapSize
    private val sharks = mutableListOf<Shark>()
    private val smellDuration = initDuration
    private val smellMap = Array(mapSize) {
        Array<Smell>(mapSize) {
            Smell()
        }
    }

    init {
        for (i in range) {
            for (j in range) {
                val sharkNum = initMap[i][j]
                if (sharkNum == 0) continue
                val dir = initSharksDir[sharkNum - 1]
                val priorityDir = initSharksPriorityDir[sharkNum - 1]
                val newShark = Shark(i, j, dir, sharkNum, priorityDir)
                sharks.add(newShark)
                smellMap[i][j] = Smell(sharkNum, smellDuration)
            }
        }

        sharks.sortBy { it.num }
    }

    fun getTimeOfAloneShark(): Int {
        var time = 0
        while (sharks.size > 1 && time <= 1000) {
            time += 1
            sharks.forEach {
                it.move()
            }
            decreaseSmell()
            sharks.removeIf { it.isOut }
            sharks.forEach { shark ->
                smellMap[shark.y][shark.x] = Smell(shark.num, smellDuration)
            }
        }
        return if (time > 1000) -1 else time
    }

    fun decreaseSmell() {
        for (i in range) {
            for (j in range) {
                val currentSmell = smellMap[i][j]
                if (currentSmell.isExist) {
                    currentSmell.duration -= 1
                }
            }
        }
    }

    fun printSharksInfo() {
        sharks.forEach {
            it.printSharkInfo()
        }
    }

    private inner class Shark(
        var y: Int,
        var x: Int,
        initDir: Int,
        val num: Int,
        val priorityDir: List<List<Int>>
    ) {
        private val dy = listOf(-1, 1, 0, 0)
        private val dx = listOf(0, 0, -1, 1)
        private var dir = initDir
        var isOut = false

        fun inMap(y: Int, x: Int): Boolean = y in 0..<mapSize && x in 0..<mapSize
        fun move() {
            for (nextDir in priorityDir[dir]) {
                val ny = y + dy[nextDir]
                val nx = x + dx[nextDir]
                if (!inMap(ny, nx)) continue
                if (smellMap[ny][nx].isExist) continue
                map[y][x] = 0
                if (map[ny][nx] != 0) {
                    isOut = true
                } else {
                    map[ny][nx] = this.num
                    y = ny
                    x = nx
                    dir = nextDir
                }
                return
            }

            for (nextDir in priorityDir[dir]) {
                val ny = y + dy[nextDir]
                val nx = x + dx[nextDir]
                if (!inMap(ny, nx)) continue
                if (map[ny][nx] != 0) continue
                if (smellMap[ny][nx].sharkNum != this.num) continue
                map[y][x] = 0
                map[ny][nx] = this.num
                y = ny
                x = nx
                dir = nextDir
                return
            }
        }

        fun printSharkInfo() {
            println("$num 번 상어, y: $y, x: $x dir: ${stringFormattingDir(dir)}")
            println("우선 순위: ")
            repeat(4) { i ->
                print("${stringFormattingDir(i)} | ")
                priorityDir[i].forEach {
                    print("${stringFormattingDir(it)} ")
                }
                println()
            }
            println()
        }

        private fun stringFormattingDir(dir: Int): String {
            return when (dir) {
                0 -> "↑"
                1 -> "↓"
                2 -> "←"
                3 -> "→"
                else -> "잘못된 입력"
            }
        }
    }

    private data class Smell(
        val sharkNum: Int = 0,
        var duration: Int = 0,
    ) {
        val isExist: Boolean
            get() = duration != 0
    }
}