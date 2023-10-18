package topologicalSorting

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var t1 = StringTokenizer(br.readLine())
    val n = t1.nextToken().toInt()
    val m = t1.nextToken().toInt()
    val g = Array(n+1){
        mutableListOf<Int>()
    }
    val ind = Array(n+1){
        0
    }
    repeat(m){
        t1 = StringTokenizer(br.readLine())
        val pn = t1.nextToken().toInt()
        var f = t1.nextToken().toInt()
        repeat(pn-1){
            val s = t1.nextToken().toInt()
            g[f].add(s)
            ind[s]++
            f = s
        }
    }

    val q = ArrayDeque<Int>()
    for(i in 1..n){
        if(ind[i] == 0){
            q.add(i)
        }
    }

    val result = mutableListOf<Int>()
    while(!q.isEmpty()){
        val t = q.removeFirst()
        result.add(t)
        for(num in g[t]){
            ind[num]--
            if(ind[num] == 0){
                q.add(num)
            }
        }
    }
    if(result.size != n){
        print(0)
    }else{
        for(num in result){
            println(num)
        }
    }
}