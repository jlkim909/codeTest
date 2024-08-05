package date_24_8_5

fun main() = with(System.`in`.bufferedReader()){
    val (n, m) = readLine().split(" ").map{it.toInt()}
    var result = 0
    val isVisited = BooleanArray(51)
    repeat(n){
        var type = 0
        var multiType = false

        val cards = readLine().split(" ").map{it.toInt()}
        for(i in 1..m){
            val x = cards[i-1]
            if(x > 0){
                if(type == 0) type = i
                else multiType = true
            }
        }

        if(multiType || isVisited[type]){
            result += 1
        }else{
            if(type != 0){
                isVisited[type] = true
            }
        }
    }

    if(result > 0){
        result-= 1
    }

    print(result)
}