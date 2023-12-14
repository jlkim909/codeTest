package Greedy

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val k = readLine().toInt()
    val sensor = readLine().split(" ").map{it.toInt()}.distinct().toMutableList()

    if(sensor.size <= k){
        print(0)
        return
    }

    sensor.sort()

    val gap = MutableList(sensor.size-1){
        abs(sensor[it] - sensor[it+1])
    }

    gap.sort()
    
    repeat(k-1){
        gap.removeLast()
    }

    print(gap.sum())
}