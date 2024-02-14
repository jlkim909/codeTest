package bfs

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (v, e) = readLine().split(" ").map { it.toInt() }
    val start = readLine().toInt()
    val inf = 1_000_000_001
    val g = Array(v + 1) {
        mutableListOf<Pair<Int, Int>>()
    }

    repeat(e) {
        val (from, to, dist) = readLine().split(" ").map { it.toInt() }
        g[from].add(Pair(to, dist))
    }
    val dist = IntArray(v + 1) { inf }
    val isVisited = BooleanArray(20001)
    dist[start] = 0
    val q = PriorityQueue<Pair<Int,Int>> {a, b -> a.second.compareTo(b.second)}
    q.add(Pair(start, 0))
    while(q.isNotEmpty()){
        val (node, d) = q.poll()
        if(isVisited[node]){
            continue
        }
        for(next in g[node]){
            if(dist[next.first] > d + next.second) {
                dist[next.first] = d + next.second
                q.add(Pair(next.first, d + next.second))
            }
        }
        isVisited[node] = true
    }

    for(i in 1..v){
        if(dist[i] == inf){
            println("INF")
        }else {
            println(dist[i])
        }
    }
}