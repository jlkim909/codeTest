package All

fun main() = with(System.`in`.bufferedReader()){
    data class Point(val y:Int, val x:Int, val d:Int = 0)
    val (n, m) = readLine().split(" ").map{it.toInt()}
    val dq = ArrayDeque<Point>()
    val dy = arrayOf(-1,0,1,0)
    val dx = arrayOf(0,1,0,-1)
    val isVisited = Array(n){
        IntArray(m){
            -1
        }
    }
    val map = Array(n){i ->
        val br = readLine().split(" ").map{it.toInt()}
        IntArray(m){j ->
            if(br[j] == 2){
                dq.add(Point(i,j))
                isVisited[i][j] = 0
            }
            if(br[j] == 0){
                isVisited[i][j] = 0
            }
            br[j]
        }
    }
    while(!dq.isEmpty()){
        val (y, x, d) = dq.removeFirst()
        for(i in 0..3){
            val ny = y + dy[i]
            val nx = x + dx[i]
            if(ny in 0 until n && nx in 0 until m){
                if(isVisited[ny][nx] == -1){
                    isVisited[ny][nx] = d + 1
                    dq.add(Point(ny,nx,d+1))
                }
            }
        }
    }

    for(i in isVisited){
        for(j in i){
            print("$j ")
        }
        println()
    }
}