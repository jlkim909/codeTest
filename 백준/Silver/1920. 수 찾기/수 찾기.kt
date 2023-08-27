package binarySearch

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val t1 = StringTokenizer(br.readLine())
    val arrA = Array(n){
        t1.nextToken().toInt()
    }
    val m = br.readLine().toInt()
    val t2 = StringTokenizer(br.readLine())
    val arrB = Array(m){
        t2.nextToken().toInt()
    }
    arrA.sort()
    for(num in arrB) {
        var start = 0
        var end = n - 1
        var isExist = false
        while (start <= end) {
            //println("${start}, ${end}")
            val mid:Int = (start + end) / 2
            if(arrA[mid] < num){
                start = mid + 1
            }else if(arrA[mid] > num){
                end = mid - 1
            }else{
                isExist = true
                break
            }
        }
        if(isExist){
            println(1)
        }else{
            println(0)
        }
    }
}