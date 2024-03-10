package greedy

import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val roads = readLine().split(" ").map{BigInteger.valueOf(it.toLong())}
    val price = readLine().split(" ").map{BigInteger.valueOf(it.toLong())}

    var result = BigInteger.valueOf(0)
    var maxPrice = BigInteger.valueOf(1_000_000_001)
    for((idx, road) in roads.withIndex()){
        if(price[idx] < maxPrice){
            maxPrice = price[idx]
        }
        result += maxPrice * road
    }

    print(result)
}