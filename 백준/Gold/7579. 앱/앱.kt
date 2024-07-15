package date_24_7

fun main() = with(System.`in`.bufferedReader()){
    val (n, m) = readLine().split(" ").map{it.toInt()}
    val d = LongArray(10001)

    val memory = readLine().split(" ").map{it.toLong()}
    val cost = readLine().split(" ").map{it.toInt()}

    for(i in 0..<n){
        for(j in 10000 downTo 0){
            if(j-cost[i] >= 0){
                d[j] = maxOf(d[j], d[j-cost[i]] + memory[i])
            }
        }
    }

    for(i in 0..<10001){
        if(d[i] >= m){
            print(i)
            return
        }
    }
}