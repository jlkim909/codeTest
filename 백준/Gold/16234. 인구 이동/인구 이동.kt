package all

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()){
    val dy = arrayOf(-1,0,1,0)
    val dx = arrayOf(0,1,0,-1)
    val (n, l, r) = readLine().split(" ").map{it.toInt()}
    val country = Array(n){_ ->
        val line = readLine().split(" ").map{it.toInt()}
        IntArray(n){
            line[it]
        }
    }
    var result = 0
    do {
        var check = false
        val isVisited = Array(n){
            BooleanArray(n){
                false
            }
        }
        for (i in 0..<n) {
            for (j in 0..<n) {
                var sum = 0
                val temp = mutableListOf<Pair<Int, Int>>()
                if (!isVisited[i][j]) {
                    isVisited[i][j] = true
                    val dq = ArrayDeque<Pair<Int, Int>>()
                    dq.add(Pair(i, j))
                    while (dq.isNotEmpty()) {
                        val (y, x) = dq.removeFirst()
                        sum += country[y][x]
                        temp.add(Pair(y, x))
                        for (k in 0..3) {
                            val ny = y + dy[k]
                            val nx = x + dx[k]
                            if (ny in 0..<n && nx in 0..<n) {
                                val gap = abs(country[y][x] - country[ny][nx])
                                if (!isVisited[ny][nx] && gap in l..r) {
                                    check = true
                                    dq.add(Pair(ny, nx))
                                    isVisited[ny][nx] = true
                                }
                            }
                        }
                    }
                    for ((sy, sx) in temp) {
                        country[sy][sx] = sum / temp.size
                    }
                }
            }
        }
        if(check){
            result++
        }
    }while(check)

    print(result)
}