package all

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    val dices = Array(n){
        readLine().split(" ").map{it.toInt()}
    }

    var result = 0
    for(i in 0..5){
        var sum = 0
        // 윗면
        var k1 = i

        // 아랫면
        var k2 = when(k1){
            0 -> 5
            1 -> 3
            2 -> 4
            3 -> 1
            4 -> 2
            5 -> 0
            else -> 0
        }
        sum += dices[0].filter{ it != dices[0][k1] && it != dices[0][k2]}.max()
        for(j in 1..< n){
            k2 = dices[j].indexOf(dices[j-1][k1])
            k1 = when(k2){
                0 -> 5
                1 -> 3
                2 -> 4
                3 -> 1
                4 -> 2
                5 -> 0
                else -> 0
            }
            sum += dices[j].filter{ it != dices[j][k1] && it != dices[j][k2]}.max()
        }
        result = maxOf(result, sum)
    }

    print(result)
}