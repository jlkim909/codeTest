package all

fun main() = with(System.`in`.bufferedReader()) {
    val board = Array(19) {
        readLine().split(" ").map { it.toInt() }
    }

    val dy = arrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
    val dx = arrayOf(0, 1, 1, 1, 0, -1, -1, -1)
    for (x in 0..18) {
        for (y in 0..18) {
            if (board[y][x] == 0) {
                continue
            }

            val color = board[y][x]
            for (k in 0..7) {
                var ny = y + dy[k]
                var nx = x + dx[k]
                val sy = y - dy[k]
                val sx = x - dx[k]

                if(sy in 0..18 && sx in 0..18 && board[sy][sx] == color){
                    continue
                }

                var check = 1

                while (ny in 0..18 && nx in 0..18 && board[ny][nx] == color) {
                    check++
                    ny += dy[k]
                    nx += dx[k]
                }
                if (check == 5) {
                    println(color)
                    print("${y + 1} ${x + 1}")
                    return
                }
            }
        }
    }

    print(0)
}