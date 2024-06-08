package all

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val l = readLine().split(" ").map { it.toInt() }
    val truths = ArrayDeque<Int>()
    val graph = Array(n + 1) {
        mutableSetOf<Int>()
    }
    val isVisited = BooleanArray(n + 1)
    for (i in 1..<l.size) {
        isVisited[l[i]] = true
        truths.add(l[i])
    }

    val partyGroup = Array(m){
        mutableListOf<Int>()
    }
    repeat(m) {partyNum ->
        val ll = readLine().split(" ").map{it.toInt()}
        for(i in 1..<ll.size){
            partyGroup[partyNum].add(ll[i])
        }
        for (i in 1..<ll.size) {
            for (j in 1..<ll.size) {
                if (i == j)
                    continue
                graph[ll[i]].add(ll[j])
            }
        }
    }

    while (truths.isNotEmpty()) {
        val node = truths.removeFirst()
        for (next in graph[node]) {
            if (!isVisited[next]) {
                isVisited[next] = true
                truths.add(next)
            }
        }
    }

    var result = 0
    for (party in partyGroup) {
        var check = false
        for(person in party){
            if(isVisited[person]){
                check = true
                break
            }
        }
        if(!check){
            result += 1
        }
    }

    print(result)
}