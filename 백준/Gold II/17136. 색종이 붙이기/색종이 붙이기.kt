package all

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {

    val map = Array(10) {
        val l = readLine().split(" ").map { it.toInt() }
        IntArray(10) {
            l[it]
        }
    }

    val paperNum = IntArray(6) {
        5
    }

    var result = Int.MAX_VALUE

    fun attach(y:Int, x:Int, size:Int, isAttach:Int){
        repeat(size){dy ->
            repeat(size){dx ->
                map[y + dy][x + dx] = isAttach
            }
        }
    }

    fun backTracking(y:Int, x:Int, usePaper:Int){
        if(y >= 10){
            result = minOf(result, usePaper)
            return
        }

        if(usePaper >= result){
            return
        }
        
        if(map[y][x] == 1){
            paperAttach@ for(i in 5 downTo 1){
                if(paperNum[i] == 0){
                    continue
                }

                for(dy in 0..<i){
                    for(dx in 0..<i){
                        if(y + dy >= 10 || x + dx >= 10 || map[y + dy][x + dx] == 0){
                            continue@paperAttach
                        }
                    }
                }

                attach(y, x, i, 0)
                paperNum[i] -= 1

                if(x + i < 10){
                    backTracking(y, x + i, usePaper + 1)
                } else{
                    backTracking(y + 1, 0, usePaper + 1)
                }

                paperNum[i] += 1
                attach(y, x, i, 1)
            }
        } else{
            if(x + 1 < 10){
                backTracking(y, x + 1, usePaper)
            }else{
                backTracking(y + 1, 0, usePaper)
            }
        }
    }

    backTracking(0, 0, 0)
    print(if(result == Int.MAX_VALUE) -1 else result)
}