package all

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()){
    val (n, m) = readLine().split(" ").map{it.toInt()}
    val rooms = Array(n + 1){
        mutableListOf<Pair<Int,Int>>()
    }
    repeat(m){
        val (a, b, c) = readLine().split(" ").map{it.toInt()}
        rooms[a].add(Pair(b,c))
        rooms[b].add(Pair(a,c))
    }

    val isVisited = BooleanArray(n + 1)
    val dist = IntArray(n+1){
        Int.MAX_VALUE
    }

    dist[1] = 0
    val pq = PriorityQueue<Pair<Int,Int>>{p1, p2 ->
        p1.second.compareTo(p2.second)
    }

    pq.add(Pair(1,0))
    while(pq.isNotEmpty()){
        val (current, currentCost) = pq.poll()
        if(dist[current] < currentCost) continue

        rooms[current].forEach{ node ->
            val next = node.first
            val nextCost = currentCost + node.second
            if(nextCost < dist[next]){
                dist[next] = nextCost
                pq.add(Pair(next, nextCost))
            }
        }
    }

    print(dist[n])
}