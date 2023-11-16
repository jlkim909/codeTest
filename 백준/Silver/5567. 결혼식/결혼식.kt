package Graph

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val m = readLine().toInt()
    val g = Array(n+1){
        mutableListOf<Int>()
    }
    repeat(m){
        val ab = readLine().split(" ").map{it.toInt()}
        g[ab[0]].add(ab[1])
        g[ab[1]].add(ab[0])
    }

    val isVisited = BooleanArray(n+1){false}
    isVisited[1] = true
    var result = 0
    for(i in g[1]){
        if(!isVisited[i]) {
            isVisited[i] = true
            result++
        }
        for(j in g[i]){
            if(!isVisited[j]){
                isVisited[j] = true
                result++
            }
        }
    }
    print(result)
}