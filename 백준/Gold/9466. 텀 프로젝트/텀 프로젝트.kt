package date_24_9_2
fun main() = with(System.`in`.bufferedReader()) {
    val testCase = readLine().toInt()
    repeat(testCase) {
        val n = readLine().toInt()
        val graph = IntArray(n + 1)
        val isVisited = BooleanArray(n + 1)
        val l = readLine().split(" ").map { it.toInt() }
        repeat(n) {
            graph[it + 1] = l[it]
        }

        var result = 0

        for(i in 1..n){
            if(!isVisited[i]) {
                val dq = ArrayDeque<Int>()
                dq.add(i)
                isVisited[i] = true
                var next = graph[i]
                while (!isVisited[next]) {
                    dq.add(next)
                    isVisited[next] = true
                    next = graph[next]
                }
                while (dq.isNotEmpty() && dq.first() != next) {
                    dq.removeFirst()
                    result += 1
                }
            }
        }
        println(result)
    }
}