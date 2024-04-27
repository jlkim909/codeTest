package all

fun main() = with(System.`in`.bufferedReader()) {
    val k = readLine().toInt()
    val n = readLine().toInt()
    val l = readLine()
    val rows = Array(n) {
        mutableListOf<Int>()
    }
    var resultRow = 0
    repeat(n) {
        val row = readLine()
        for ((idx, c) in row.withIndex()) {
            if (c == '-') {
                rows[it].add(idx)
            } else if (c == '?') {
                resultRow = it
                break
            }
        }
    }
    val start = Array(k) {
        'A' + it
    }

    val end = Array(k) {
        l[it]
    }

    for (i in 0..<resultRow) {
        for (col in rows[i]) {
            val temp = start[col]
            start[col] = start[col + 1]
            start[col + 1] = temp
        }
    }

    for (i in n - 1 downTo resultRow + 1) {
        for (col in rows[i]) {
            val temp = end[col]
            end[col] = end[col + 1]
            end[col + 1] = temp
        }
    }

    var p = 0
    var result = ""
    while (p < k - 1) {
        if (start[p] != end[p]) {
            val temp = start[p]
            start[p] = start[p + 1]
            start[p + 1] = temp
            result += '-'
        }else{
            result += '*'
        }
        p += 1
    }

    if (start.contentEquals(end)) {
        print(result)
    } else {
        for (i in 0..<k - 1) {
            print('x')
        }
    }
}