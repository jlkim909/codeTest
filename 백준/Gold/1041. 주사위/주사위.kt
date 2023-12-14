package Greedy

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val s = readLine().split(" ").map{it.toInt()}
    val dice = IntArray(6){ i ->
        s[i]
    }

    if(n == 1){
        print(dice.sum() - dice.max())
        return
    }

    var side3Min = 200
    for(i in 0..3){
        for(j in i+1..4){
            for(k in j+1..5){
                if(i+j == 5 || i+k == 5 || j+k == 5){
                    continue
                }
                val sum = dice[i] + dice[j] + dice[k]
                if(side3Min > sum){
                    side3Min = sum
                }
            }
        }
    }

    var side2Min = 100
    for(i in 0..4){
        for(j in i+1..5){
            if(i+j==5){
                continue
            }
            val sum = dice[i] + dice[j]
            if(side2Min > sum){
                side2Min = sum
            }
        }
    }

    var sideMin = dice.min()

    // println("$side3Min, ${side2Min}, ${sideMin}")
    val side2Num = 8*n - 12
    val result:Long = 4*side3Min + side2Num*side2Min +
            (5L*n*n - 16*n + 12)*sideMin

    // println("${4*side3Min}, ${side2Num*side2Min}, ${(5*n*n - 16*n + 12)*sideMin}")
    print(result)
}