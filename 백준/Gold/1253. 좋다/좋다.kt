package all

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val arr = readLine().split(" ").map{it.toInt()}.sorted()

    var result = 0
    for(i in 0..<n){
        var start = 0
        var end = n - 1
        while(start < end){
            if(start == i){
                start += 1
            }
            if(end == i){
                end -= 1
            }
            if(start >= end){
                break
            }
            val sumNum = arr[start] + arr[end]

            if(sumNum < arr[i]){
                start += 1
            }else if(sumNum > arr[i]){
                end -= 1
            }else{
                result += 1
                break
            }
        }
    }

    print(result)
}