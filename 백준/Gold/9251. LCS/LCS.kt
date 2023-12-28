package dp

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()){
    val s1 = readLine()
    val s2 = readLine()

    val d = Array(1001){
        IntArray(1001){
            -1
        }
    }
    
    fun dpFun(p1:Int, p2:Int):Int{
        if(p1 < 0 || p2 < 0){
            return 0
        }
        if(d[p1][p2] != -1){
            return d[p1][p2]
        }

        if(s1[p1] == s2[p2]){
            d[p1][p2] = dpFun(p1-1, p2-1) + 1
        }else{
            d[p1][p2] = max(dpFun(p1, p2-1),dpFun(p1-1,p2))
        }
        return d[p1][p2]
    }
    println(dpFun(s1.length-1, s2.length-1))
}