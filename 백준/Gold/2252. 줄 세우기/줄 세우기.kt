package topologicalSorting

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var t1 = StringTokenizer(br.readLine())
    val n = t1.nextToken().toInt()
    val m = t1.nextToken().toInt()
    val ind = Array(n+1){
        0
    }
    val g = Array(n+1){
        mutableListOf<Int>()
    }
    repeat(m){
        t1 = StringTokenizer(br.readLine())
        val f = t1.nextToken().toInt()
        val s = t1.nextToken().toInt()
        g[f].add(s)
        g[s].add(f)
        ind[s]++
    }

    val q = ArrayDeque<Int>()
    for(i in 1..n){
        if(ind[i] == 0){
            q.add(i)
        }
    }
    while(!q.isEmpty()){
        val t = q.removeFirst()
        print("$t ")
        for(num in g[t]){
            ind[num]--
            if(ind[num] == 0){
                q.add(num)
            }
        }
    }
}