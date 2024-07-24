package date_24_7_24

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val row = mutableListOf<String>()
    val arr = Array(n) { i ->
        val l = readLine()
        row.add(l)
        IntArray(m) { j ->
            l[j].digitToInt()
        }
    }

    val k = readLine().toInt()

    val checkRow = BooleanArray(n)
    for (i in 0..<n) {
        var cnt = 0
        for (j in 0..<m) {
            if (arr[i][j] == 0) {
                cnt += 1
            }
        }
        if ((cnt % 2 == k % 2) && cnt <= k) {
            checkRow[i] = true
        }
    }

    var result = 0
    for (i in 0..<n) {
        if (checkRow[i]) {
            var cnt = 0
            for (j in 0..<n) {
                if (row[i] == row[j]) {
                    cnt += 1
                }
            }
            result = maxOf(result, cnt)
        }
    }

    print(result)
}