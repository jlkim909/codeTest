package All

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val board = Array(n){
        Array(n){
            0
        }
    }
    repeat(n){i ->
        val st = StringTokenizer(br.readLine())
        repeat(n){j ->
            board[i][j] = st.nextToken().toInt()
        }
    }

    var result = 0
    for(i in 0..3){
        result = maxOf(result, startGame(n,1,i,board))
    }
    print(result)
}

private fun startGame(n:Int, move:Int, dir:Int, board:Array<Array<Int>>):Int{
    if(move == 6){
        var max = 0
        for(i in board){
            for(j in i){
                if(max < j) max = j
            }
        }
        return max
    }
    var max = 0
    var temp = board
    when(dir){
        0 -> {
            temp = sumUp(n, temp)
        }
        1 -> {
            temp.reverse()
            temp = sumUp(n, temp)
            temp.reverse()
        }
        2 -> {
            temp = sumLeft(n, temp)
        }
        3 -> {
            for(i in 0 until n){
                temp[i].reverse()
            }
            temp = sumLeft(n, temp)
            for(i in 0 until n){
                temp[i].reverse()
            }
        }
    }

    for(i in 0..3){
        max = maxOf(max, startGame(n,move+1,i, temp))
    }
    return max
}

private fun sumUp(n:Int, board:Array<Array<Int>>):Array<Array<Int>>{
    val temp = Array(n){
        Array(n){
            0
        }
    }
    for(i in 0 until n){
        var r = 0
        for(j in 0 until n){
            if(board[j][i] != 0){
                temp[r][i] = board[j][i]
                r++
            }
        }
    }

    for(i in 1 until n){
        for(j in 0 until n){
            if(temp[i-1][j] == temp[i][j]){
                temp[i-1][j] *= 2
                temp[i][j] = 0
            }
        }
    }

    val temp2 = Array(n){
        Array(n){
            0
        }
    }

    for(i in 0 until n){
        var r = 0
        for(j in 0 until n){
            if(temp[j][i] != 0){
                temp2[r][i] = temp[j][i]
                r++
            }
        }
    }

    return temp2
}

private fun sumLeft(n:Int, board:Array<Array<Int>>):Array<Array<Int>>{
    val temp = Array(n){
        Array(n){
            0
        }
    }
    for(i in 0 until n){
        var c = 0
        for(j in 0 until n){
            if(board[i][j] != 0){
                temp[i][c] = board[i][j]
                c++
            }
        }
    }

    for(i in 0 until n){
        for(j in 1 until n){
            if(temp[i][j-1] == temp[i][j]){
                temp[i][j-1] *= 2
                temp[i][j] = 0
            }
        }
    }

    val temp2 = Array(n){
        Array(n){
            0
        }
    }
    for(i in 0 until n){
        var c = 0
        for(j in 0 until n){
            if(temp[i][j] != 0){
                temp2[i][c] = temp[i][j]
                c++
            }
        }
    }

    return temp2
}