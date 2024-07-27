package date_24_7_29

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c) = readLine().split(" ").map { it.toInt() }
    data class Point(val y: Int, val x: Int, val d: Int)

    val dy = arrayOf(-1, 0, 1, 0)
    val dx = arrayOf(0, 1, 0, -1)
    val map = Array(r) {
        val l = readLine()
        CharArray(c) {
            l[it]
        }
    }

    val sp = mutableListOf<Pair<Int, Int>>()
    for (i in 0..<r) {
        for (j in 0..<c) {
            if (map[i][j] == 'L') {
               sp.add(Pair(i,j))
            }
        }
    }

    var result = 0

    while (sp.isNotEmpty()) {
        val (sy, sx) = sp.removeFirst()
        val isVisited = Array(r) { BooleanArray(c) }
        val q = ArrayDeque<Point>()
        q.add(Point(sy, sx, 0))
        isVisited[sy][sx] = true
        while (q.isNotEmpty()) {
            val (y, x, d) = q.removeFirst()
            if(result < d){
                result = d
            }
            for(k in 0..3){
                val ny = y + dy[k]
                val nx = x + dx[k]
                if(ny in 0..<r && nx in 0..<c){
                    if(!isVisited[ny][nx] && map[ny][nx] == 'L'){
                        isVisited[ny][nx] = true
                        q.add(Point(ny, nx, d + 1))
                    }
                }
            }
        }
    }

    print(result)
}