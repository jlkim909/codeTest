package binarySearch

fun main() = with(System.`in`.bufferedReader()){
    val (s, c) = readLine().split(" ").map{it.toInt()}
    val scallions = LongArray(s){
        readLine().toLong()
    }

    var start = 1L
    var end = 1_000_000_000L
    var length = 0L
    while(start <= end){
        val mid:Long = (start+end)/2
        var sum = 0L
        for(scallion in scallions){
            sum += scallion / mid
        }
        if(sum < c){
            end = mid - 1
        }else{
            length = maxOf(length, mid)
            start = mid + 1
        }
    }

    print(scallions.sum() - length * c)
}