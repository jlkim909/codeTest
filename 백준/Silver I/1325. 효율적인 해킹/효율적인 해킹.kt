package bfs

fun main() = with(System.`in`.bufferedReader()){
    val (n ,m) = readLine().split(" ").map{it.toInt()}
    val g = Array(n+1){
        mutableListOf<Int>()
    }

    val result = IntArray(n+1)
    repeat(m){
        val (a, b) = readLine().split(" ").map{it.toInt()}
        g[a].add(b)
    }

    for(i in 1..n){
        val isVisited = BooleanArray(n+1)
        isVisited[i] = true
        val q = ArrayDeque<Int>()
        q.add(i)

        while(q.isNotEmpty()){
            val node = q.removeFirst()
            for(next in g[node]){
                if(!isVisited[next]){
                    isVisited[next] = true
                    q.add(next)
                    result[next]++
                }
            }
        }
    }

    val max = result.max()
    for(i in 1..n){
        if(result[i] == max){
            print("$i ")
        }
    }
}