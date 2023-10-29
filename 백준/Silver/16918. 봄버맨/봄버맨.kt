package All

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    data class Boom(val y:Int, val x:Int, var t:Int)
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    var n = st.nextToken().toInt()
    val dy = arrayOf(-1, 0, 1, 0)
    val dx = arrayOf(0, 1, 0, -1)
    val board = Array(r){i ->
        val s = br.readLine()
        Array(c){j ->
            if(s[j] == 'O') Boom(i, j, 2) else Boom(i, j, 0)
        }
    }

    n--

    while(n > 0){
        for(i in board){
            for(j in i){
                j.t++
            }
        }
        n--
        if(n <= 0) break

        for(i in 0 until r){
            for(j in 0 until c){
                if(board[i][j].t == 3){
                    for(k in 0..3){
                        val ny = i+dy[k]
                        val nx = j+dx[k]
                        if(ny in 0 until r && nx in 0 until c && board[ny][nx].t != 3){
                            board[ny][nx].t = 0
                        }
                    }
                    board[i][j].t = 0
                }
                if(board[i][j].t > 0){
                    board[i][j].t++
                }
            }
        }
        n--
        if(n <= 0) break
    }

    for(i in board){
        for(j in i){
            if(j.t == 0){
                print(".")
            }else{
                print("O")
            }
        }
        println()
    }
}