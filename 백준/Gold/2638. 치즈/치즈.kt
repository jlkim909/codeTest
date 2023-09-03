package BFSDFS

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val dy = arrayOf(-1, 1, 0, 0)
    val dx = arrayOf(0,0,-1,1)
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t1 = StringTokenizer(br.readLine())
    val n = t1.nextToken().toInt()
    val m = t1.nextToken().toInt()
    val isCheese = Array(n){
        val t2 = StringTokenizer(br.readLine())
        Array(m){
            t2.nextToken().toInt()
        }
    }
    var result = -1
    do {
        result++
        var temp = Array(n){ni ->
            Array(m){mi ->
                isCheese[ni][mi]
            }
        }
        var q = ArrayDeque<P>()
        q.add(P(0, 0))
        val visited = Array(n){
            Array(m){
                false
            }
        }
        visited[0][0] = true
        while (!q.isEmpty()) {
            val p = q.removeFirst()
            val x = p.x
            val y = p.y
            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue
                if (visited[ny][nx]) continue
                if (temp[ny][nx] > 0) {
                    temp[ny][nx]++
                    continue
                }
                visited[ny][nx] = true
                q.add(P(ny, nx))
            }
        }

        var isEnd = true
        for (pn in 0 until n) {
            for (pm in 0 until m) {
                if (temp[pn][pm] > 2) {
                    isCheese[pn][pm] = 0
                    isEnd = false
                }
            }
        }
    }while(!isEnd)
    print(result)
}
private data class P(val y:Int, val x:Int)