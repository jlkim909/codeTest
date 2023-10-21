package topologicalSorting

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    data class Node(val v:Int, val e:Int)
    val inf = 1_000_000_000
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val end = st.nextToken().toInt()

    val g = Array(n+1){
        mutableListOf<Node>()
    }
    val dist = Array(n+1){
        Array(n+1){
            inf
        }
    }
    val check = Array(n+1){
        Array(n+1){
            false
        }
    }
    repeat(m){
        st = StringTokenizer(br.readLine())
        val v1 = st.nextToken().toInt()
        val v2 = st.nextToken().toInt()
        val d = st.nextToken().toInt()
        g[v1].add(Node(v2,d))
    }
    for(i in 1..n){
        dist[i][i] = 0
    }
    for(i in 1..n){
        for(k in 0 until n-1){
            var m = inf+1
            var x = -1
            for(j in 1..n){
                if(!check[i][j] && m > dist[i][j]){
                    m = dist[i][j]
                    x = j
                }
            }
            check[i][x] = true
            for(node in g[x]){
                val y = node.v
                if(dist[i][y] > dist[i][x] + node.e){
                    dist[i][y] = dist[i][x] + node.e
                }
            }
        }
    }
    var result = 0
    for(i in 1..n){
        if(result < dist[i][end] + dist[end][i]){
            result = dist[i][end] + dist[end][i]
        }
    }
    print(result)
}
