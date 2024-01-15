package binarySearch

fun main() = with(System.`in`.bufferedReader()){
    val (m,n) = readLine().split(" ").map{it.toInt()}
    val snacks = readLine().split(" ").map{it.toInt()}

    var s = 1
    var e = 1_000_000_000
    var result = 0

    if(snacks.sum() - m < 0){
        print(0)
        return
    }
    while(s <= e){
        val mid = (s+e)/2
        var sum = 0
        for(snack in snacks){
            sum += snack / mid
        }

        if(sum < m){
            e = mid - 1
        }else{
            s = mid + 1
            result = maxOf(result, mid)
        }
    }

    print(result)
}