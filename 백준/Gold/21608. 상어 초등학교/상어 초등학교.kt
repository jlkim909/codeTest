package All

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val room = Array(n){
        IntArray(n){
            0
        }
    }
    val dy = arrayOf(-1,0,1,0)
    val dx = arrayOf(0,1,0,-1)
    val isInRange = {y:Int, x:Int -> y in 0 until n && x in 0 until n}
    val studentPreferenceArr = Array(n*n+1){
        mutableListOf<Int>()
    }
    repeat(n*n){
        val l = readLine().split(" ").map{it.toInt()}
        val student = l[0]
        val p = l.slice(1..4)
        studentPreferenceArr[student] = p.toMutableList()
        var emptySpaceCnt = -1
        var pCnt = -1
        var y = 0
        var x = 0
        for(i in 0 until n){
            for(j in 0 until n){
                if(room[i][j] != 0){
                    continue
                }
                var tp = 0
                var tes = 0
                for(k in 0..3){
                    val ny = i + dy[k]
                    val nx = j + dx[k]
                    if(isInRange(ny,nx)){
                        if(p.contains(room[ny][nx])){
                            tp++
                        }
                        if(room[ny][nx] == 0){
                            tes++
                        }
                    }
                }
                if(tp > pCnt){
                    y = i
                    x = j
                    pCnt = tp
                    emptySpaceCnt = tes
                }else if(tp == pCnt && emptySpaceCnt < tes){
                    y = i
                    x = j
                    emptySpaceCnt = tes
                }
            }
        }

        room[y][x] = student

    }

    var result = 0
    for(i in 0 until n){
        for(j in 0 until n){
            var pCnt = 0
            for(k in 0..3){
                val ny = i + dy[k]
                val nx = j + dx[k]
                if(isInRange(ny,nx)){
                    if(studentPreferenceArr[room[i][j]].contains(room[ny][nx])){
                        pCnt++
                    }
                }
            }
            when(pCnt){
                1 -> result+=1
                2 -> result+=10
                3 -> result+=100
                4 -> result+=1000
            }
        }
    }

    print(result)
}