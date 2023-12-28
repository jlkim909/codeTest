package dp

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()){
    val wireNum = readLine().toInt()


    var aMax = 0
    var bMax = 0
    val isWire = Array(501){
        BooleanArray(501){
            false
        }
    }
    repeat(wireNum){
        val (a, b) = readLine().split(" ").map{it.toInt()}

        isWire[a][b] = true

        if(a > aMax){
            aMax = a
        }

        if(b > bMax){
            bMax = b
        }
    }
    val d = Array(501){
        IntArray(501){
            -1
        }
    }

    fun dpFun(p1:Int, p2:Int):Int{
        if(p1 <= 0 || p2 <= 0){
            return 0
        }

        if(d[p1][p2] != -1){
            return d[p1][p2]
        }

        val plus = if(isWire[p1][p2]) 1 else 0

        d[p1][p2] = max(dpFun(p1-1, p2), dpFun(p1,p2-1)) + plus
        return d[p1][p2]
    }

    print(wireNum - dpFun(aMax, bMax))
}