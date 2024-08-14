package date_24_8_12
fun main() = with(System.`in`.bufferedReader()){
    val (c, n) = readLine().split(" ").map{it.toInt()}
    val adList = mutableListOf<Pair<Int,Int>>()
    repeat(n){
        val (cost, clientNum) = readLine().split(" ").map{it.toInt()}
        adList.add(Pair(cost, clientNum))
    }

    val d = IntArray(1_000_001)

    for(ad in adList){
        val (cost, clientNum) = ad
        for(j in 1..1_000_000){
            if(j-cost >= 0) {
                d[j] = maxOf(d[j], d[j - cost] + clientNum)
            }
        }
    }

    for(i in 1..1_000_000){
        if(d[i] >= c){
            print(i)
            break
        }
    }
}