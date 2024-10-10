package date_24_10_7

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    @Suppress("SpellCheckingInspection")
    val monominoDomino2 = MonominoDomino2()
    repeat(n) {
        val (t, y, x) = readLine().split(" ").map { it.toInt() }
        monominoDomino2.addBlock(t, y, x)
    }

    println(monominoDomino2.getScore())
    print(monominoDomino2.getBlockCnt())
}

@Suppress("SpellCheckingInspection")
private class MonominoDomino2() {
    val green = Board()
    val blue = Board()

    fun addBlock(type: Int, y: Int, x: Int) {
        green.fillBlock(type, x)
        val blueType = when (type) {
            2 -> 3
            3 -> 2
            else -> 1
        }
        val blueX = if (type == 3) 2 - y else 3 - y
        blue.fillBlock(blueType, blueX)
    }

    fun getScore(): Int {
        return green.score + blue.score
    }

    fun getBlockCnt(): Int {
        return green.getBlockCnt() + blue.getBlockCnt()
    }
}

private class Board() {
    inner class Row() {
        private val emptyColumn = BooleanArray(4) { true }
        private var emptySpaceCnt = 4
        fun isEmptyColumn(x: Int): Boolean {
            return emptyColumn[x]
        }

        fun fill(x: Int) {
            emptyColumn[x] = false
            emptySpaceCnt -= 1
            if (emptySpaceCnt == 0) {
                board.remove(this)
                score += 1
                board.add(0, Row())
            }
        }

        fun getFillCnt(): Int = 4 - emptySpaceCnt
        fun isEmpty(): Boolean = emptySpaceCnt == 4
    }

    private val board = MutableList(6) {
        Row()
    }
    var score = 0
        private set

    fun getBlockCnt(): Int {
        var cnt = 0
        board.forEach {
            cnt += it.getFillCnt()
        }

        return cnt
    }

    fun fillBlock(type: Int, x: Int) {
        var ny = 0
        while (canStack(type, ny + 1, x)) {
            ny += 1
        }

        when (type) {
            1 -> {
                board[ny].fill(x)
            }

            2 -> {
                board[ny].fill(x)
                board[ny].fill(x + 1)
            }

            3 -> {
                board[ny].fill(x)
                board[ny + 1].fill(x)
            }
        }

        while (!board[1].isEmpty()) {
            deleteBottom()
        }
    }

    private fun canStack(type: Int, y: Int, x: Int): Boolean {
        if (y > 5) return false
        return when (type) {
            1 -> {
                board[y].isEmptyColumn(x)
            }

            2 -> {
                board[y].isEmptyColumn(x) && board[y].isEmptyColumn(x + 1)
            }

            else -> {
                if (y + 1 > 5) {
                    false
                } else {
                    board[y].isEmptyColumn(x) && board[y + 1].isEmptyColumn(x)
                }
            }
        }
    }

    private fun deleteBottom() {
        board.removeLast()
        board.add(0, Row())
    }
}