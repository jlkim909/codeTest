package BFSDFS

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val g = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }

    repeat(n - 1) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        g[a].add(b to c)
        g[b].add(a to c)
    }

    var result = 0
    fun dfs(node:Int, isVisited:BooleanArray, d:Int){
        for(next in g[node]){
            if(!isVisited[next.first]) {
                isVisited[next.first] = true
                dfs(next.first, isVisited, d+next.second)
                isVisited[next.first] = false
            }
        }
        if(result < d){
            result = d
        }
    }
    val isVisited = BooleanArray(n+1){false}
    for(i in 1..n){
        if(g[i].size == 1){
            isVisited[i] = true
            dfs(i,isVisited,0)
        }
    }
    print(result)
}
