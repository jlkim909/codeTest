package All

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    data class Ball(var ry:Int, var rx:Int, var by:Int, var bx :Int, var move:Int = 0)
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val dy = arrayOf(-1, 0, 1, 0)
    val dx = arrayOf(0, 1, 0, -1)
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val board = Array(n){
        val s = br.readLine()
        Array(m){i ->
            s[i]
        }
    }
    val isVisited = Array(10){
        Array(10){
            Array(10){
                Array(10){
                    false
                }
            }
        }
    }
    val ball = Ball(0,0,0,0)
    for(i in 0 until n){
        for(j in 0 until m){
            if(board[i][j] == 'R'){
                ball.ry = i
                ball.rx = j
                board[i][j] = '.'
            }
            if(board[i][j] == 'B'){
                ball.by = i
                ball.bx = j
                board[i][j] = '.'
            }
        }
    }
    val dq = ArrayDeque<Ball>()
    dq.add(ball)
    isVisited[ball.ry][ball.rx][ball.by][ball.bx] = true
    while(!dq.isEmpty()){
        val ball = dq.removeFirst()
        var ry = ball.ry
        var rx = ball.rx
        var by = ball.by
        var bx = ball.bx
        var m = ball.move
        if(m>=10){
            break
        }
        for(i in 0..3){
            var isRedStop = false
            var isBlueStop = false
            var isRedGoal = false
            var isBlueGoal = false
            var nry = ry
            var nrx = rx
            var nby = by
            var nbx = bx
            while(!isRedStop || !isBlueStop){
                if(!isRedStop) {
                    nry += dy[i]
                    nrx += dx[i]
                    if(nry == nby && nrx == nbx && board[nry][nrx] != 'O'){
                        nry -= dy[i]
                        nrx -= dx[i]
                        if(isBlueStop){
                            isRedStop = true
                        }
                    }
                    when(board[nry][nrx]){
                        '#' -> {
                            nry -= dy[i]
                            nrx -= dx[i]
                            isRedStop = true
                        }
                        'O' -> {
                            isRedStop = true
                            isRedGoal = true
                        }
                    }
                }
                if(!isBlueStop) {
                    nby += dy[i]
                    nbx += dx[i]
                    if(nry == nby && nrx == nbx && board[nry][nrx] != 'O'){
                        nby -= dy[i]
                        nbx -= dx[i]
                        if(isRedStop){
                            isBlueStop = true
                        }
                    }
                    when(board[nby][nbx]){
                        '#' -> {
                            nby -= dy[i]
                            nbx -= dx[i]
                            isBlueStop = true
                        }
                        'O' -> {
                            isBlueStop = true
                            isBlueGoal = true
                        }
                    }
                }
            }
            if(isRedGoal && !isBlueGoal){
                print(m + 1)
                return
            }
            if(!isRedGoal && !isBlueGoal) {
                if (!isVisited[nry][nrx][nby][nbx]) {
                    isVisited[nry][nrx][nby][nbx] = true
                    dq.add(Ball(nry, nrx, nby, nbx, m + 1))
                }
            }
        }
    }

    print(-1)
}