package dp

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val tetrahedron = IntArray(150){
        0
    }
    tetrahedron[1] = 1
    var k = 2
    var w = 3
    var s = 3
    while(tetrahedron[k-1]<300_000){
        tetrahedron[k] = tetrahedron[k-1] + s
        s += w++
        k++
    }

    var result = Int.MAX_VALUE

    fun dpFun(ball:Int, q:Int, num:Int){
        if(q == 0){
            return
        }
        if(ball == 0){
            if(result > num){
                result = num
            }
            return
        }

        if(result < num){
            return
        }

        if(tetrahedron[q] <= ball){
            dpFun(ball-tetrahedron[q], q, num+1)
        }

        dpFun(ball, q-1, num)
    }

    dpFun(n, 120,0)

    println(result)
}