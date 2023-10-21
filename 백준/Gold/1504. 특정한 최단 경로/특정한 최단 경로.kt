package topologicalSorting

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val e = st.nextToken().toInt()
    val g = Array(n+1){
        mutableListOf<Node>()
    }
    val inf = 1_000_000_000L

    val dist = Array(3){
        Array(n+1){
            inf
        }
    }
    val check = Array(3){
        Array(n+1){
            false
        }
    }
    repeat(e){
        st = StringTokenizer(br.readLine())
        val node1 = st.nextToken().toInt()
        val node2 = st.nextToken().toInt()
        val dist = st.nextToken().toInt()
        g[node1].add(Node(node2, dist))
        g[node2].add(Node(node1, dist))
    }
    st = StringTokenizer(br.readLine())
    val v1 = st.nextToken().toInt()
    val v2 = st.nextToken().toInt()

    dist[0][1] = 0
    dist[1][v1] = 0
    dist[2][v2] = 0

    for(p in 0..2) {
        for (k in 0 until n - 1) {
            var m = inf + 1
            var x = -1
            for (i in 1..n) {
                if (!check[p][i] && m > dist[p][i]) {
                    m = dist[p][i]
                    x = i
                }
            }
            check[p][x] = true
            for (t in g[x]) {
                val y = t.n
                if (dist[p][y] > dist[p][x] + t.d) {
                    dist[p][y] = dist[p][x] + t.d
                }
            }
        }
    }

    val path1:Long = dist[0][v1]+dist[1][v2]+dist[2][n]
    val path2:Long = dist[0][v2]+dist[2][v1]+dist[1][n]
    if(path1 >= inf || path2 >= inf){
        print(-1)
    }else {
        print(minOf(path1, path2))
    }
}

private data class Node(val n:Int, val d:Int)