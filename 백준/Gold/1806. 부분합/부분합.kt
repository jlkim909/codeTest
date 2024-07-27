package date_24_7_29

fun main() = with(System.`in`.bufferedReader()){
    val (n, s) = readLine().split(" ").map{it.toInt()}
    val arr = readLine().split(" ").map{it.toInt()}
    var end = 0
    var sum = 0
    var result = 100_001
    var check = false
    for(start in 0..<n){
        while(sum < s && end < n){
            sum += arr[end]
            end += 1
        }

        if(sum >= s){
            if(result > end - start){
                result = end - start
                check = true
            }
        }

        sum -= arr[start]
    }

    if(check) {
        print(result)
    }else{
        print(0)
    }
}