package All

import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()){
    val rotate = {wheel:String, isLeft:Boolean ->
        if(isLeft) {
            wheel.slice(1..7) + wheel[0]
        }else{
            wheel[7] + wheel.slice(0..6)
        }
    }

    val wheels = Array(4){
        readLine()
    }

    fun rotateWheel(num:Int, isLeft:Boolean, isVisited:BooleanArray){
        isVisited[num] = true
        if(num+1 < 4 && wheels[num][2] != wheels[num+1][6]
            && !isVisited[num+1]){
            rotateWheel(num + 1, !isLeft, isVisited)
        }

        if(num-1 >= 0 && wheels[num][6] != wheels[num-1][2]
            && !isVisited[num-1]){
            rotateWheel(num - 1, !isLeft, isVisited)
        }
        wheels[num] = rotate(wheels[num], isLeft)
    }

    val k = readLine().toInt()

    repeat(k){
        val (n, d) = readLine().split(" ").map{it.toInt()}
        val isVisited = BooleanArray(4){false}
        rotateWheel(n-1,d == -1, isVisited)
    }

    var result = 0
    for((i,w) in wheels.withIndex()){
        if(w[0] == '1'){
            result+=2.0.pow(i).toInt()
        }
    }
    print(result)
}