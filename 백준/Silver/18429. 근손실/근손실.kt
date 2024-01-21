package all

fun main() = with(System.`in`.bufferedReader()){
    val (n, k) = readLine().split(" ").map{it.toInt()}
    val l = readLine().split(" ").map{it.toInt()}
    val kit = Array(n){
        l[it]
    }

    fun gym(weight:Int, isVisited:BooleanArray, d:Int):Int{
        if(weight < 500){
            return 0
        }
        if(d == n){
            return 1
        }
        var result = 0
        for(i in 0..<n){
            if(!isVisited[i]){
                isVisited[i] = true
                result += gym(weight-k+kit[i], isVisited, d+1)
                isVisited[i] = false
            }
        }

        return result
    }

    val isVisited = BooleanArray(n){false}

    print(gym(500, isVisited, 0))

}