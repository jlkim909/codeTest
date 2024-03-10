package greedy

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val coins = Array(n) {
        val l = readLine()
        BooleanArray(m) {
            l[it] == '0'
        }
    }

    var a = n - 1
    var b = m - 1
    val standard = coins[a][b]

    var result = 0

    fun switchCoin(r: Int, c: Int) {
        for (i in 0..r) {
            for (j in 0..c) {
                coins[i][j] = !coins[i][j]
            }
        }
        result += 1
    }
    while (a >= 0 || b >= 0) {
        if(b >= 0) {
            for (i in a downTo 0) {
                if (coins[i][b] != standard) {
                    switchCoin(i, b)
                }
            }
        }
        if(a >= 0) {
            for (i in b downTo 0) {
                if (coins[a][i] != standard) {
                    switchCoin(a, i)
                }
            }
        }
        a-=1
        b-=1
    }

    if(!standard){
        result+=1
    }
    print(result)
}