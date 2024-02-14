package bfs

fun main() = with(System.`in`.bufferedReader()){
    val (m, n) = readLine().split(" ").map{it.toInt()}
    val field = Array(n){
        readLine()
    }

    val dy = arrayOf(-1, 0, 1, 0)
    val dx = arrayOf(0, 1, 0, -1)
    val q = ArrayDeque<Pair<Int,Int>>()
    val isVisited = Array(n){
        BooleanArray(m)
    }

    var w = 0
    var b = 0
    for(i in 0..<n){
        for(j in 0..<m){
            if(!isVisited[i][j]){
                var soldier = 1
                val color = field[i][j]
                q.add(Pair(i, j))
                isVisited[i][j] = true
                while(q.isNotEmpty()){
                    val (y, x) = q.removeFirst()
                    for(t in 0..3){
                        val ny = y + dy[t]
                        val nx = x + dx[t]
                        if(ny in 0..<n && nx in 0..<m){
                            if(!isVisited[ny][nx] && color == field[ny][nx]){
                                q.add(Pair(ny, nx))
                                isVisited[ny][nx] = true
                                soldier++
                            }
                        }
                    }
                }
                val power = soldier * soldier
                if(color == 'W'){
                    w+= power
                }else{
                    b+= power
                }
            }
        }
    }

    print("$w $b")
}