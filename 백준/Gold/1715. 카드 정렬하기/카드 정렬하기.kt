package Greedy

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val card = PriorityQueue<Long>()
    repeat(n){
        card.add(readLine().toLong())
    }

    var result = 0L
    while(card.size != 1){
        val sum = card.poll() + card.poll()
        result+=sum
        card.add(sum)
    }

    print(result)
}