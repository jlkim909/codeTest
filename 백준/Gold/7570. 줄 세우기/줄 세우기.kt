package greedy

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map{it.toInt()}
    val d = Array(n+1){0}
    var longest = 0
    for(i in 0 until n){
        val num = arr[i]
        d[num] = d[num-1]+1
        if(longest < d[num]){
            longest = d[num]
        }
    }

    print(n-longest)
}