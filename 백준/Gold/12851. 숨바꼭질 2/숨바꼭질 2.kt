package bfs

fun main() = with(System.`in`.bufferedReader()){
    val (n, k) = readLine().split(" ").map{it.toInt()}
    val q = ArrayDeque<Pair<Int,Int>>()
    q.add(Pair(n,0))
    val isVisited = BooleanArray(200_001)

    var minTime = 200_001
    var result = 0
    while(q.isNotEmpty()){
        val (c, s) = q.removeFirst()
        isVisited[c] = true
        if(minTime < s){
            continue
        }
        if(c == k){
            if(minTime > s){
                minTime = s
            }
            result++
        }
        if(c+1 < 200_001 && !isVisited[c+1]){
            q.add(Pair(c+1, s + 1))
        }

        if(c-1 >= 0 && !isVisited[c-1]){
            q.add(Pair(c-1, s + 1))
        }

        if(c*2 < 200_001 && !isVisited[c*2]){
            q.add(Pair(c*2, s + 1))
        }
    }
    println(minTime)
    println(result)
}