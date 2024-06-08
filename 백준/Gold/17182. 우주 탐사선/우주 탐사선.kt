package all

fun main() = with(System.`in`.bufferedReader()){
    val (n, k) = readLine().split(" ").map{it.toInt()}
    val dist = Array(n){
        IntArray(n)
    }
    repeat(n){i ->
        readLine().split(" ").mapIndexed{j, value ->
            dist[i][j] = value.toInt()
        }
    }

    for(t in 0..<n){
        for(i in 0..<n){
            for(j in 0..<n){
                dist[t][j] = minOf(dist[t][i] + dist[i][j], dist[t][j])
            }
        }
    }

    var result = Int.MAX_VALUE
    fun searchGraph(node:Int, sn:Int, isVisited:BooleanArray, sum:Int){
        if(sn == n){
            if(sum < result){
                result = sum
            }
            return
        }
        isVisited[node] = true
        for(i in 0..<n){
            if(isVisited[i])
                continue
            isVisited[i] = true
            searchGraph(i, sn + 1, isVisited, sum + dist[node][i])
            isVisited[i] = false
        }
    }

    val isVisited = BooleanArray(n)
    searchGraph(k, 1, isVisited, 0)
    print(result)
}