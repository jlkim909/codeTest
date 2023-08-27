package binarySearch

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val t1 = StringTokenizer(br.readLine())
    val arr = Array(n){
        t1.nextToken().toInt()
    }
    val m = br.readLine().toInt()
    var first = 0
    var end = 0
    for(i in arr){
        end = maxOf(i, end)
    }
    var result = 0
    while(first<=end){
        var sum = 0
        val mid = (first+end)/2
        for(i in arr){
            if(i <= mid){
                sum+=i
            }else{
                sum+=mid
            }
        }

        if(sum<=m){
            result = mid
            first = mid + 1
        }else {
            end = mid - 1
        }
    }
    println(result)
}