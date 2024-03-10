package greedy

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val times = mutableListOf<Pair<Int,Int>>()
    repeat(n){
        val (s, e) = readLine().split(" ").map{it.toInt()}
        times.add(Pair(s,e))
    }

    times.sortBy { it.first }

    val q = PriorityQueue<Pair<Int,Int>>{a, b ->
        a.second.compareTo(b.second)
    }
    var result = 0
    for(i in times){
        if(q.isNotEmpty()){
            if(i.first >= q.first().second){
                q.poll()
            }
        }
        q.add(i)
        if(result < q.size){
            result = q.size
        }
    }

    print(result)
}