package greedy

fun main() = with(System.`in`.bufferedReader()){
    val (n, l) = readLine().split(" ").map{it.toInt()}
    val points = readLine().split(" ").map{it.toInt()}.sorted()
    val isRepair = BooleanArray(5001)
    var result = 0

    for(point in points){
        if(!isRepair[point]){
            result+=1
            for(i in point..<point+l){
                isRepair[i] = true
            }
        }
    }

    print(result)
}