package greedy

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val roads = readLine().split(" ").map{it.toInt()}
    val price = readLine().split(" ").map{it.toInt()}

    var result = 0
    var maxPrice = Int.MAX_VALUE
    for((idx, road) in roads.withIndex()){
        if(price[idx] < maxPrice){
            maxPrice = price[idx]
        }
        result += maxPrice * road
    }

    print(result)
}