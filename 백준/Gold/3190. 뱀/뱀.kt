package All

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    data class Snake(var y:Int, var x:Int)
    val dy = arrayOf(0, 1, 0, -1)
    val dx = arrayOf(1, 0, -1, 0)
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val board = Array(n + 2){i ->
        Array(n + 2){j ->
            if(i==0 || i==n+1 || j==0 || j==n+1) 2
            else 0
        }
    }
    val dirTime = Array(10_000){
        'N'
    }
    val k = br.readLine().toInt()
    repeat(k){
        val st = StringTokenizer(br.readLine())
        board[st.nextToken().toInt()][st.nextToken().toInt()] = 1
    }
    val l = br.readLine().toInt()
    repeat(l){
        val st = StringTokenizer(br.readLine())
        dirTime[st.nextToken().toInt()] = st.nextToken()[0]
    }

    board[1][1] = 2
    val dq = ArrayDeque<Snake>()
    dq.add(Snake(1,1))
    var dir = 0
    var second = 0
    val snake = Snake(1,1)
    while(true){
        second++
        snake.y += dy[dir]
        snake.x += dx[dir]
        val ny = snake.y
        val nx = snake.x
        if(board[ny][nx] == 2){
            break
        }
        if(board[ny][nx] != 1){
            val p = dq.removeFirst()
            board[p.y][p.x] = 0
        }
        board[ny][nx] = 2
        dq.add(Snake(ny,nx))
        if(dirTime[second] == 'D'){
            dir++
            if(dir == 4) dir = 0

        }else if(dirTime[second] == 'L'){
            dir--
            if(dir < 0) dir = 3
        }
    }

    print(second)
}