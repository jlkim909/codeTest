package all

fun main() = with(System.`in`.bufferedReader()) {
    val (n, r, q) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) {
        mutableListOf<Int>()
    }

    repeat(n - 1) {
        val (f, s) = readLine().split(" ").map { it.toInt() }
        graph[f].add(s)
        graph[s].add(f)
    }
    val d = IntArray(n+1){-1}
    fun searchTree(s:Int) : Int{
        d[s] = 0
        var sum = 0
        for(child in graph[s]){
            if(d[child] == -1) {
                sum += searchTree(child) + 1
            }
        }
        d[s] = sum

        return d[s]
    }

    searchTree(r)

    repeat(q){
        val u = readLine().toInt()
        println(d[u] + 1)
    }
}