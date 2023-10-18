package topologicalSorting

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val g = Array(n+1){
        mutableListOf<Pair<Int,Int>>()
    }
    val inf = 1_000_000_000
    val check = Array(n+1){
        false
    }

    val dist = Array(n+1){
        inf
    }

    repeat(m){
        val t1 = StringTokenizer(br.readLine())
        val s = t1.nextToken().toInt()
        val e = t1.nextToken().toInt()
        val d = t1.nextToken().toInt()
        g[s].add(Pair(e,d))
    }

    val t1 = StringTokenizer(br.readLine())
    val start = t1.nextToken().toInt()
    val end = t1.nextToken().toInt()

    dist[start] = 0
    for(k in 0 until n-1){
        var m = inf + 1
        var x = -1
        for(i in 1..n){
            if(!check[i] && m > dist[i]){
                m = dist[i]
                x = i
            }
        }
        check[x] = true
        for(t in g[x]){
            val y = t.first
            if(dist[y] > dist[x] + t.second){
                dist[y] = dist[x] + t.second
            }
        }
    }

    print(dist[end])

}