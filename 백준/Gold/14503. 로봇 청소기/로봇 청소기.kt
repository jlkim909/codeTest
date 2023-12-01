package All

fun main() = with(System.`in`.bufferedReader()){
    val (n, m) = readLine().split(" ").map{it.toInt()}
    var (ry, rx, rd) = readLine().split(" ").map{it.toInt()}
    val dy = arrayOf(-1,0,1,0)
    val dx = arrayOf(0,1,0,-1)

    val room = Array(n){
        val l = readLine().split(" ").map{it.toInt()}
        IntArray(m){
            l[it]
        }
    }

    var result = 0
    val isInRange = {y:Int, x:Int -> y in 0 until n && x in 0 until m}
    while(true){
        if(room[ry][rx] == 0){
            room[ry][rx] = 2
            result++
        }
        var isClean = true
        for(k in 0..3){
            val ny = ry + dy[k]
            val nx = rx + dx[k]
            if(isInRange(ny,nx) && room[ny][nx] == 0){
                isClean = false
                break
            }
        }

        if(isClean){
            val nd = (rd+2)%4
            val ny = ry + dy[nd]
            val nx = rx + dx[nd]
            if(isInRange(ny,nx) && room[ny][nx] != 1){
                ry = ny
                rx = nx
            }else{
                break
            }
        }else{
            do {
                var check = false
                val nd = (rd + 3) % 4
                val ny = ry + dy[nd]
                val nx = rx + dx[nd]
                if (isInRange(ny, nx) && room[ny][nx] == 0) {
                    ry = ny
                    rx = nx
                    rd = (rd+3) % 4
                    check = true
                }else{
                    rd = (rd+3) % 4
                }
            }while(!check)
        }
    }

    print(result)
}