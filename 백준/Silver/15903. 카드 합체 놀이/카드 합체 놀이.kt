package greedy

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Collections
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t1 = StringTokenizer(br.readLine())
    val n = t1.nextToken().toInt()
    val m = t1.nextToken().toInt()
    val t2 = StringTokenizer(br.readLine())
    val pq = PriorityQueue<Long>()
    repeat(n){
        pq.add(t2.nextToken().toLong())
    }

    repeat(m){
        val c1 = pq.poll()
        val c2 = pq.poll()
        pq.add(c1+c2)
        pq.add(c1+c2)
    }
    var result = 0L
    for(num in pq){
        result+=num
    }

    print(result)
}