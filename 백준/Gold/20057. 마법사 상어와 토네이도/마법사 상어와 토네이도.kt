package date_24_9_30

val dy = listOf(0, 1, 0, -1)
val dx = listOf(-1, 0, 1, 0)

private val ratio = listOf(
    listOf(
        listOf(0, 0, 2, 0, 0),
        listOf(0, 10, 7, 1, 0),
        listOf(5, 0, 0, 0, 0),
        listOf(0, 10, 7, 1, 0),
        listOf(0, 0, 2, 0, 0),
    ),
    listOf(
        listOf(0, 0, 0, 0, 0),
        listOf(0, 1, 0, 1, 0),
        listOf(2, 7, 0, 7, 2),
        listOf(0, 10, 0, 10, 0),
        listOf(0, 0, 5, 0, 0),
    ),
    listOf(
        listOf(0, 0, 2, 0, 0),
        listOf(0, 1, 7, 10, 0),
        listOf(0, 0, 0, 0, 5),
        listOf(0, 1, 7, 10, 0),
        listOf(0, 0, 2, 0, 0),
    ),
    listOf(
        listOf(0, 0, 5, 0, 0),
        listOf(0, 10, 0, 10, 0),
        listOf(2, 7, 0, 7, 2),
        listOf(0, 1, 0, 1, 0),
        listOf(0, 0, 0, 0, 0),
    ),
)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = Array(n) {
        val inp = readLine().split(" ").map { it.toInt() }
        IntArray(n) {
            inp[it]
        }
    }

    var moveCnt = 1
    var dir = 0
    var y = n / 2
    var x = n / 2

    var result = 0

    while (y in 0..<n && x in 0..<n) {
        repeat(moveCnt) {
            y += dy[dir]
            x += dx[dir]
            if (y in 0..<n && x in 0..<n) {
                if (map[y][x] != 0) {
                    val totalSandAmount = map[y][x]
                    map[y][x] = 0
                    var totalSplitSandAmount = 0
                    for (i in 0..4) {
                        for (j in 0..4) {
                            val ny = y + i - 2
                            val nx = x + j - 2
                            val splitSandAmount = (totalSandAmount * ratio[dir][i][j]) / 100
                            if (splitSandAmount < 1) continue

                            totalSplitSandAmount += splitSandAmount
                            if (ny in 0..<n && nx in 0..<n) {
                                map[ny][nx] += splitSandAmount
                            } else {
                                result += splitSandAmount
                            }
                        }
                    }

                    val aY = y + dy[dir]
                    val aX = x + dx[dir]
                    if (aY in 0..<n && aX in 0..<n) {
                        map[aY][aX] += totalSandAmount - totalSplitSandAmount
                    } else {
                        result += totalSandAmount - totalSplitSandAmount
                    }
                }
            }
        }

        if (dir % 2 == 1) {
            moveCnt += 1
        }
        dir = (dir + 1) % 4
    }

    print(result)
}