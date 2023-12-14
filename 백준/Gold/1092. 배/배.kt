package Greedy

import kotlin.math.ceil

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val crane = readLine().split(" ").map{it.toInt()}.toMutableList()
    val m = readLine().toInt()
    val box = readLine().split(" ").map{it.toInt()}.toMutableList()
    crane.sort()
    box.sort()

    while(true){
        if(crane.isEmpty()){
            break
        }
        if(crane.first() < box.first()){
            crane.removeFirst()
        }else{
            break
        }
    }

    var result = ceil(box.size.toDouble()/crane.size.toDouble())
    var minTime = 0.0

    while(crane.isNotEmpty() && box.isNotEmpty()) {
        val c = crane.first()
        val remainBoxNum = box.size
        val remainCraneNum = crane.size
        var k = 0
        minTime = ceil(remainBoxNum.toDouble()/remainCraneNum.toDouble())
        if(minTime > result){
            result = minTime
        }
        while (box.isNotEmpty() && k < minTime) {
            if(c >= box.first()){
                box.removeFirst()
            }else{
                break
            }
            k++
        }
        crane.removeFirst()
    }

    if(box.isNotEmpty()){
        print(-1)
        return
    }
    print(result.toInt())
}