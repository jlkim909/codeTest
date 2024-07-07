package start

fun main() = with(System.`in`.bufferedReader()) {
    val l = readLine().split(" ")
    val n = l[0].toInt()
    var b = l[1].toLong()

    var matrix = Array(n) {
        val l = readLine().split(" ").map { it.toInt() }
        IntArray(n) {
            l[it]
        }
    }

    var result = Array(n) { i ->
        IntArray(n) { j ->
            if (i == j) 1 else 0
        }
    }

    fun mulMatrix(m1: Array<IntArray>, m2: Array<IntArray>): Array<IntArray> {
        val newMatrix = Array(n) { IntArray(n) }
        for (i in 0..<n) {
            for (j in 0..<n) {
                for (k in 0..<n) {
                    newMatrix[i][j] += m1[i][k] * m2[k][j]
                }
                newMatrix[i][j] %= 1000
            }
        }

        return newMatrix
    }


    while(b > 0){
        if(b % 2L == 1L){
            result = mulMatrix(result, matrix)
        }
        matrix = mulMatrix(matrix, matrix)
        b /= 2
    }

    for(i in 0..<n){
        for(j in 0..<n){
            print("${result[i][j]} ")
        }
        println()
    }
}