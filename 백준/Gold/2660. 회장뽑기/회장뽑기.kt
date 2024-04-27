package all

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val friends = Array(n+1){
        mutableListOf<Int>()
    }
    while(true){
        val (f, s) = readLine().split(" ").map{it.toInt()}
        if(f == -1 || s == -1){
            break
        }
        friends[f].add(s)
        friends[s].add(f)
    }

    val result = Array(n + 1){
        mutableListOf<Int>()
    }
    repeat(n){
        val start = it + 1
        val isVisited = BooleanArray(n+1)
        isVisited[start] = true
        val q = ArrayDeque<Pair<Int,Int>>()
        q.add(Pair(start, 0))

        var score = 0
        while(q.isNotEmpty()){
            val (current, depth) = q.removeFirst()
            for(friend in friends[current]){
                if(!isVisited[friend]){
                    q.add(Pair(friend, depth + 1))
                    isVisited[friend] = true
                }
            }
            score = depth
        }
        result[score].add(start)
    }

    for(i in 1..n){
        if(result[i].size != 0){
            println("$i ${result[i].size}")
            for(f in result[i].sorted()){
                print("$f ")
            }
            break
        }
    }
}