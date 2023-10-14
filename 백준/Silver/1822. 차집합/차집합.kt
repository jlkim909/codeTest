package binarySearch

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var t1 = StringTokenizer(br.readLine())
    val n = t1.nextToken().toInt()
    val m = t1.nextToken().toInt()
    t1 = StringTokenizer(br.readLine())
    val arrA = Array(n){
        t1.nextToken().toInt()
    }
    t1 = StringTokenizer(br.readLine())
    val arrB = Array(m){
        t1.nextToken().toInt()
    }

    arrA.sort()

    val isExist = Array(500_001){
        false
    }

    for(num in arrB){
        var start = 0
        var end = arrA.size - 1
        while(start <= end){
            val mid = (start+end)/2
            if(arrA[mid] < num){
                start = mid + 1
            }else if(arrA[mid] > num){
                end = mid - 1
            }else{
                isExist[mid] = true
                break
            }
        }
    }

    val result = mutableListOf<Int>()
    for(i in arrA.indices){
        if(isExist[i]) continue
        result.add(arrA[i])
    }

    println(result.size)
    for(n in result){
        print("$n ")
    }
}