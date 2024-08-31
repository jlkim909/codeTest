package date_24_9_2

private val dy = arrayOf(-1, 0, 1, 0)
private val dx = arrayOf(0, 1, 0, -1)
private lateinit var map: Array<String>
private var r = 0
private var c = 0
private lateinit var isVisited: Array<BooleanArray>
private var firePosition = ArrayDeque<Pair<Int, Int>>()
private var jiminPosition = ArrayDeque<JiminPosition>()
fun main() = with(System.`in`.bufferedReader()) {
    val l = readLine().split(" ").map { it.toInt() }
    r = l[0]
    c = l[1]

    map = Array(r) {
        readLine()
    }

    isVisited = Array(r) {
        BooleanArray(c)
    }

    for (i in 0..<r) {
        for (j in 0..<c) {
            when (map[i][j]) {
                'J' -> {
                    jiminPosition.add(JiminPosition(i, j, 0))
                }

                'F' -> {
                    firePosition.add(Pair(i, j))
                }

                '.' -> {
                    continue
                }
            }
            isVisited[i][j] = true
        }
    }

    escapeMaze()
}

private fun escapeMaze() {
    var time = -1
    while (time == -1) {
        moveFire()
        time = escapeJimin()
    }

    if (time == 0) {
        print("IMPOSSIBLE")
    } else {
        print(time)
    }
}

private fun moveFire() {
    val newFirePosition = ArrayDeque<Pair<Int, Int>>()
    while (firePosition.isNotEmpty()) {
        val (y, x) = firePosition.removeFirst()
        for (i in 0..3) {
            val ny = y + dy[i]
            val nx = x + dx[i]
            if (ny in 0..<r && nx in 0..<c) {
                if (!isVisited[ny][nx]) {
                    isVisited[ny][nx] = true
                    newFirePosition.add(Pair(ny, nx))
                }
            }
        }
    }

    firePosition = newFirePosition
}

private fun escapeJimin(): Int {
    if (jiminPosition.isEmpty()) {
        return 0
    }
    val newJiminPosition = ArrayDeque<JiminPosition>()
    while (jiminPosition.isNotEmpty()) {
        val (y, x, time) = jiminPosition.removeFirst()
        if (y == 0 || x == 0 || y == r - 1 || x == c - 1) {
            return time + 1
        }
        for (i in 0..3) {
            val ny = y + dy[i]
            val nx = x + dx[i]
            if (ny in 0..<r && nx in 0..<c) {
                if (!isVisited[ny][nx]) {
                    isVisited[ny][nx] = true
                    newJiminPosition.add(JiminPosition(ny, nx, time + 1))
                }
            }
        }
    }

    jiminPosition = newJiminPosition

    return -1
}

private data class JiminPosition(val y: Int, val x: Int, val time: Int)