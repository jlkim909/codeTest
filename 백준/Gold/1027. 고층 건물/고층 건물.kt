package all

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val building = readLine().split(" ").map{it.toDouble()}
    val viewCnt = IntArray(n)

    for(i in 0..<n){
        var maxGradient:Double = -1_000_000_001.0
        for(j in i+1..<n){
            val gradient = (building[j] - building[i]) / (j-i)
            if(maxGradient < gradient){
                viewCnt[j] += 1
                viewCnt[i] += 1
                maxGradient = gradient
            }
        }
    }

    var result = 0
    for(cnt in viewCnt){
        if(result < cnt){
            result = cnt
        }
    }

    print(result)
}