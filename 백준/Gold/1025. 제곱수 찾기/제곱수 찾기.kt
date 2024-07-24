package date_24_7_24

import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) {
        val l = readLine()
        IntArray(m) {
            l[it].digitToInt()
        }
    }

    var result = -1
    fun isSquare(num: Int): Boolean {
        val temp = sqrt(num.toDouble()).toInt()
        return temp * temp == num
    }
    for (i in 0..<n) {
        for (j in 0..<m) {
            for (di in -n..<n) {
                for (dj in -m..<m) {
                    if (di == 0 && dj == 0) {
                        continue
                    }

                    var t = 0
                    var ti = i
                    var tj = j
                    while (ti in 0..<n && tj in 0..<m) {
                        t = 10 * t + arr[ti][tj]
                        if (isSquare(t)) {
                            result = maxOf(result, t)
                        }

                        ti += di
                        tj += dj
                    }
                }
            }
        }
    }

    print(result)
}