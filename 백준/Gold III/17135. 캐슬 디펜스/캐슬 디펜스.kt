package all

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, d) = readLine().split(" ").map { it.toInt() }
    val dy = arrayOf(0, -1, 0)
    val dx = arrayOf(-1, 0, 1)

    data class Archer(val y: Int, val x: Int, val move: Int, val num: Int)

    val map = Array(n + 1) {
        IntArray(m)
    }

    repeat(n) {
        readLine().split(" ").map { it.toInt() }.forEachIndexed { idx, s ->
            map[it][idx] = s
        }
    }

    var result = 0
    for (i in 0..<m) {
        for (j in i + 1..<m) {
            for (k in j + 1..<m) {
                var sum = 0
                val tempMap = Array(n + 1) {map[it].copyOf()}
                repeat(n) { round ->
                    val q = ArrayDeque<Archer>()
                    val check = BooleanArray(3)
                    val isVisited = Array(3) {
                        Array(n) {
                            BooleanArray(m)
                        }
                    }

                    q.add(Archer(n - round, i, 0, 0))
                    q.add(Archer(n - round, j, 0, 1))
                    q.add(Archer(n - round, k, 0, 2))

                    val killPoint = mutableSetOf<Pair<Int,Int>>()
                    while (q.isNotEmpty()) {
                        val (y, x, move, num) = q.removeFirst()
                        if(move > d){
                            continue
                        }
                        if(check[num]){
                            continue
                        }
                        if(tempMap[y][x] == 1) {
                            check[num] = true
                            killPoint.add(Pair(y, x))
                            continue
                        }
                        for (o in 0..2) {
                            val ny = y + dy[o]
                            val nx = x + dx[o]
                            if (ny in 0..<n - round && nx in 0..<m) {
                                if (!isVisited[num][ny][nx]) {
                                    q.add(Archer(ny, nx, move + 1, num))
                                    isVisited[num][ny][nx] = true
                                }
                            }
                        }
                    }

                    killPoint.forEach{(y, x) ->
                        tempMap[y][x] = 0
                        sum++
                    }
                }

                if(result < sum){
                    result = sum
                }
            }
        }
    }
    print(result)
}