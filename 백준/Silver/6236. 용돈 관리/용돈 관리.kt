package binarySearch

fun main() = with(System.`in`.bufferedReader()){
    val (n, m) = readLine().split(" ").map{it.toInt()}
    val pays = IntArray(n){
        readLine().toInt()
    }

    var s = pays.max()
    var e = 1_000_000_000
    var result = 1_000_000_000
    while(s <= e){
        val mid = (s+e)/2
        var restCash = 0
        var sum = 0
        for(pay in pays){
            if(restCash - pay >= 0){
                restCash -= pay
            }else{
                restCash = mid-pay
                sum++
            }
        }

        if(sum > m){
            s = mid + 1
        }else{
            e = mid - 1
            result = minOf(result, mid)
        }
    }
    print(result)
}