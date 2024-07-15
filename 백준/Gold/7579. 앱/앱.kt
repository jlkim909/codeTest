package date_24_7

fun main() = with(System.`in`.bufferedReader()){
    val (n, m) = readLine().split(" ").map{it.toInt()}
    val d = Array(n){
        LongArray(10001)
    }

    val memory = readLine().split(" ").map{it.toLong()}
    val cost = readLine().split(" ").map{it.toInt()}

    d[0][cost[0]] = memory[0]

    for(i in 1..<n){
        for(j in 0..<10001){
            d[i][j] = d[i-1][j]
            if(j-cost[i] >= 0){
                d[i][j] = maxOf(d[i][j], d[i-1][j-cost[i]] + memory[i])
            }
        }
    }

    for(i in 0..10001){
        if(d[n-1][i] >= m){
            print(i)
            return
        }
    }
}
