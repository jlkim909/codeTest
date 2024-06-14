package date_24_6_17

import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    // red : 1
    // green : 2
    // blue : 3
    // purple : 4
    // yellow : 5

    val dy = listOf(-1, 0, 1, 0)
    val dx = listOf(0, 1, 0, -1)

    var field = Array(6){
        IntArray(12)
    }

    val temp = Array(12) {
        val l = readLine()
        IntArray(6) {
            when (l[it]) {
                'R' -> 1
                'G' -> 2
                'B' -> 3
                'P' -> 4
                'Y' -> 5
                else -> 0
            }
        }
    }

    // 90도 회전
    for(i in 0..<6){
        for(j in 0..<12){
            field[i][j] = temp[11-j][i]
        }
    }


    var result = 0
    while(true){
        var check = false
        for (color in 1..5) {
            val fieldColor = Array(6) { i ->
                IntArray(12) { j ->
                    if (field[i][j] == color) color else 0
                }
            }
            val isVisited = Array(6){i ->
                BooleanArray(12){j ->
                    fieldColor[i][j] != color
                }
            }
            for(i in 0..<6){
                for(j in 0..<12){
                    if(!isVisited[i][j]){
                        val q = ArrayDeque<Pair<Int,Int>>()
                        val destroy = Stack<Pair<Int,Int>>()
                        q.add(Pair(i,j))
                        isVisited[i][j] = true
                        destroy.add(Pair(i,j))
                        while(q.isNotEmpty()){
                            val (y, x) = q.removeFirst()
                            for(k in 0..3){
                                val ny = y + dy[k]
                                val nx = x + dx[k]
                                if(ny in 0..<6 && nx in 0..<12
                                    && !isVisited[ny][nx]){
                                    q.add(Pair(ny,nx))
                                    destroy.add(Pair(ny,nx))
                                    isVisited[ny][nx] = true
                                }
                            }
                        }
                        if(destroy.size >= 4){
                            while(destroy.isNotEmpty()){
                                val (y, x) = destroy.pop()
                                fieldColor[y][x] = 0
                                field[y][x] = 0
                            }
                            check = true
                        }
                    }
                }
            }
        }

        if(check){
            result+=1
            val newField = Array(6){
                IntArray(12)
            }
            for(i in 0..<6){
                field[i].filter{it != 0}.forEachIndexed { idx, value ->
                    newField[i][idx] = value
                }
            }

            field = newField
        }else{
            break
        }
    }

    print(result)
}