package All

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val hall = Array(n){
        val st = StringTokenizer(br.readLine())
        Array(n){
            st.nextToken()[0]
        }
    }

    if(setWallAndIsTrue(n, 0, 0, 0, hall)){
        print("YES")
    }else{
        print("NO")
    }
}

private fun setWallAndIsTrue(n:Int, wallCnt:Int, y:Int, x:Int, hall:Array<Array<Char>>):Boolean{
    if(wallCnt == 3){
        return isLook(n, hall)
    }
    var nx = x
    var ny = y
    while(true){
        if(nx >= n){
            nx = 0
            ny++
        }
        if(ny >= n) break
        if(hall[ny][nx] == 'X') {
            hall[ny][nx] = 'O'
            if (setWallAndIsTrue(n, wallCnt + 1, ny, nx+1, hall)) {
                return true
            }
            hall[ny][nx] = 'X'
        }
        nx++
    }

    return false
}
private fun isLook(n:Int, hall:Array<Array<Char>>):Boolean{
    val dy = arrayOf(-1, 0, 1, 0)
    val dx = arrayOf(0, 1, 0, -1)
    for(i in 0 until n){
        for(j in 0 until n){
            if(hall[i][j] == 'T'){
                for(k in 0..3){
                    var ny = i
                    var nx = j
                    while(true){
                        ny += dy[k]
                        nx += dx[k]
                        if(ny >= n || ny < 0 || nx >= n || nx < 0) break
                        if(hall[ny][nx] == 'O') break
                        if(hall[ny][nx] == 'S') return false
                    }
                }
            }
        }
    }
    return true
}