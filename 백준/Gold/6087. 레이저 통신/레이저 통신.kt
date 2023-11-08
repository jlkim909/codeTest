package BFSDFS

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    data class P(val y:Int, val x:Int, val dir:Int, val t:Int)
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val w = st.nextToken().toInt()
    val h = st.nextToken().toInt()
    val dy = arrayOf(-1, 0, 1, 0)
    val dx = arrayOf(0, 1, 0, -1)
    val map = Array(h){
        val s = br.readLine()
        Array(w){j ->
            s[j]
        }
    }
    val isVisited = Array(h){
        Array(w){
            Array(2){
                false
            }
        }
    }
    val dq = ArrayDeque<P>()
    for(i in 0 until h){
        if(!dq.isEmpty()) break
        for(j in 0 until w){
            if(map[i][j] == 'C'){
                isVisited[i][j][0] = true
                isVisited[i][j][1] = true
                for (k in 0..3) {
                    val ny = i + dy[k]
                    val nx = j + dx[k]
                    if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue
                    if (map[ny][nx] == '*') continue
                    isVisited[ny][nx][k%2] = true
                    dq.add(P(ny, nx, k, 0))
                }
                map[i][j] = '.'
                break
            }
        }
    }
    var result = 10001
    while(!dq.isEmpty()){
        val p = dq.removeFirst()
        val y = p.y
        val x = p.x
        val dir = p.dir
        val t = p.t
        isVisited[y][x][dir%2] = true
        if(map[y][x] == 'C'){
            print(t)
            return
        }
        for(i in 0..3){
            val ny = y + dy[i]
            val nx = x + dx[i]
            if(ny < 0 || ny >= h || nx < 0 || nx >= w) continue
            if(map[ny][nx] == '*' || isVisited[ny][nx][i%2]) continue
            if(dir == i){
                dq.addFirst(P(ny,nx,i,t))
            }else {
                dq.add(P(ny, nx, i, t + 1))
            }
        }
    }
    print(result)
}