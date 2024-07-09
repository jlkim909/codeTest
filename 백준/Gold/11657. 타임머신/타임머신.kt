package start

const val INF = 100_000_000L
fun main() = with(System.`in`.bufferedReader()){
    data class Bus(val from:Int, val to:Int, val cost:Int)
    val (n, m) = readLine().split(" ").map{it.toInt()}
    val a = mutableListOf<Bus>()
    repeat(m){
        val (f, t, c) = readLine().split(" ").map{it.toInt()}
        a.add(Bus(f,t,c))
    }
    val dist = LongArray(n+1){INF}
    dist[1]= 0
    var checkCycle =false
    for(i in 1..n){
        for(j in 0..<m){
            val (from, to, cost) = a[j]
            if(dist[from] != INF && dist[to] > dist[from]+cost){
                dist[to] = dist[from] + cost
                if(i == n){
                    checkCycle = true
                }
            }
        }
    }
    if(checkCycle){
        print(-1)
    }else{
        for(i in 2..n){
            if(dist[i] == INF){
                dist[i] = -1
            }
            println(dist[i])
        }
    }
}