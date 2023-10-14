package binarySearch

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    var t1 = StringTokenizer(br.readLine())
    val n = t1.nextToken().toInt()
    val m = t1.nextToken().toLong()
    t1 = StringTokenizer(br.readLine())
    val wood = Array(n){
        t1.nextToken().toLong()
    }

    wood.sort()
    var start = 0L
    var end = wood[n-1]
    var h = 0L
    while(start <= end) {
        val mid : Long = (start+end)/2L
        var sum = 0L
        for(w in wood) {
            if (w > mid) {
                sum += w - mid
            }
        }

        if(sum >= m) {
            if(h < mid){
                h = mid
            }
            start = mid + 1
        }else{
            end = mid - 1
        }
    }
    print(h)
}