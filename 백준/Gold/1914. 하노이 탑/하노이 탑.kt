package date_24_9_23

import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()


    fun hanoi(startPosition: Int, endPosition: Int, num: Int) {
        if(num == 1){
            println("$startPosition $endPosition")
            return
        }
        var temp = 0
        for(i in 1..3) {
            if(i != startPosition && i!= endPosition) {
                hanoi(startPosition, i, num - 1)
                temp = i
            }
        }
        println("$startPosition $endPosition")
        hanoi(temp,endPosition,num-1)
    }

    val result = BigInteger.valueOf(2).pow(n) - BigInteger.valueOf(1)
    println(result)
    if(n <= 20){
        hanoi(1, 3, n)
    }
}