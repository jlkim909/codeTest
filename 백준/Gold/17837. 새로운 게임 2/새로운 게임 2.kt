package date_24_10_7

// 4개 이상 쌓이면 게임 종료
// 흰색(0) : 이동
// 빨간색(1) : 리버스
// 파란색(2) : 방향전환 + 한칸 이동
// 맵 밖 : 파란색과 같음

private val dy = listOf(0, 0, -1, 1)
private val dx = listOf(1, -1, 0, 0)

private enum class Tile {
    WHITE, RED, BLUE
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }

    val map = Array(n + 2) {
        Array(n + 2) {
            Tile.BLUE
        }
    }

    repeat(n) { i ->
        readLine().split(" ").mapIndexed { j, v ->
            map[i + 1][j + 1] = when (v.toInt()) {
                0 -> Tile.WHITE
                1 -> Tile.RED
                else -> Tile.BLUE
            }
        }
    }

    val newGame2 = NewGame2(
        initialMap = map
    )
    repeat(k) {
        val (y, x, dir) = readLine().split(" ").map { it.toInt() }
        val newPiece = Piece(y, x, dir - 1)
        newGame2.addPiece(newPiece)
    }

    while (!newGame2.isGameEnd()) {
        newGame2.turn()
    }

    print(newGame2.getTurns())
}

private class NewGame2(
    initialMap: Array<Array<Tile>>,
) {
    private var turnCnt = 0
    private var isEnd = false

    private val pieces = mutableListOf<Piece>()
    private val piecesPosition = Array(initialMap.size) {
        Array(initialMap.size) {
            mutableListOf<Piece>()
        }
    }
    private val map = initialMap

    fun addPiece(piece: Piece) {
        pieces.add(piece)
        piecesPosition[piece.y][piece.x].add(piece)
    }

    fun isGameEnd(): Boolean {
        return isEnd || turnCnt > 1000
    }

    fun getTurns(): Int {
        return if (turnCnt > 1000) {
            -1
        } else {
            turnCnt
        }
    }

    fun turn() {
        turnCnt += 1
        for (p in pieces) {
            if (!p.canMove(map)) {
                p.changeDir()
                continue
            }
            val nextPosition = p.nextPosition()
            if (getTileColor(nextPosition) == Tile.BLUE) {
                p.changeDir()
            }
            splitAndMovePieces(p)
            if (piecesPosition[p.y][p.x].size >= 4) {
                isEnd = true
                break
            }
        }
    }

    private fun getTileColor(position: Pair<Int, Int>): Tile {
        val (y, x) = position
        return map[y][x]
    }

    private fun splitAndMovePieces(piece: Piece) {
        val currentPieces = piecesPosition[piece.y][piece.x]
        val movePieces = currentPieces.dropWhile { it != piece }.toMutableList()
        currentPieces.removeAll(movePieces)
        val nextPosition = piece.nextPosition()
        if (getTileColor(nextPosition) == Tile.RED) {
            movePieces.reverse()
        }
        movePieces.forEach {
            it.move(piece.dir)
        }
        piecesPosition[nextPosition.first][nextPosition.second].addAll(movePieces)
    }

    private fun getPiecesPositionSize(position: Pair<Int, Int>): Int {
        val (y, x) = position
        return piecesPosition[y][x].size
    }
}

private class Piece(
    var y: Int,
    var x: Int,
    var dir: Int,
) {
    fun nextPosition(): Pair<Int, Int> {
        val ny = y + dy[dir]
        val nx = x + dx[dir]

        return Pair(ny, nx)
    }

    fun move(moveDir: Int) {
        y += dy[moveDir]
        x += dx[moveDir]
    }

    fun changeDir() {
        dir = when (dir) {
            0 -> 1
            1 -> 0
            2 -> 3
            else -> 2
        }
    }

    fun canMove(map: Array<Array<Tile>>): Boolean {
        val ny = y + dy[dir]
        val nx = x + dx[dir]
        val ny2 = y - dy[dir]
        val nx2 = x - dx[dir]
        return map[ny][nx] != Tile.BLUE || map[ny2][nx2] != Tile.BLUE
    }
}