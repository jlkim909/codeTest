package BFSDFS

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    data class P(val y:Int, val x:Int)
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val dy = arrayOf(-1,0,1,0)
    val dx = arrayOf(0,1,0,-1)
    val board = Array(n){
        st = StringTokenizer(br.readLine())
        Array(m){
            st.nextToken().toInt() == 1
        }
    }
    var result1 = 0
    var result2 = 0
    for(i in 0 until n) {
        for (j in 0 until m) {
            if (board[i][j]) {
                result1++
                board[i][j] = false
                val dq = ArrayDeque<P>()
                dq.add(P(i, j))
                var area = 0
                while (!dq.isEmpty()) {
                    val p = dq.removeFirst()
                    val x = p.x
                    val y = p.y
                    area++
                    for (i in 0..3) {
                        val ny = y + dy[i]
                        val nx = x + dx[i]
                        if (ny in 0 until n && nx in 0 until m
                            && board[ny][nx]
                        ) {
                            board[ny][nx] = false
                            dq.add(P(ny, nx))
                        }
                    }
                }
                if (result2 < area) {
                    result2 = area
                }
            }
        }
    }
    println(result1)
    println(result2)
}