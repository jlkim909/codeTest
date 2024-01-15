package binarySearch

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()){
    val (m, n, l) = readLine().split(" ").map{it.toInt()}
    val shoots = readLine().split(" ").map{it.toInt()}.sorted()

    var result = 0
    repeat(n){
        val (x, y) = readLine().split(" ").map{it.toInt()}
        var s = 0
        var e = m-1
        while(s <= e){
            val mid = (s+e)/2
            val dx = shoots[mid]-x
            val isShooting = (abs(dx) + y) <= l
            if(isShooting){
                result++
                break
            }

            if(dx < 0){
                s = mid + 1
            }else if( dx > 0){
                e = mid -1
            }else{
                break
            }
        }
    }
    print(result)
}