package dp

fun main() = with(System.`in`.bufferedReader()){
    val t = readLine().toInt()

    val d = Array(2){
        IntArray(41)
    }
    d[0][0] = 1
    d[0][1] = 0
    d[1][0] = 0
    d[1][1] = 1

    for(i in 2..40){
        d[0][i] = d[0][i-1] + d[0][i-2]
        d[1][i] = d[1][i-1] + d[1][i-2]
    }
    repeat(t){
        val n = readLine().toInt()
        println("${d[0][n]} ${d[1][n]}")
    }
}