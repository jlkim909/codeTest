package date_24_11_13

private val bw = System.out.bufferedWriter()
fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        getAllExpression(n)
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}

private fun getAllExpression(
    size: Int,
    n: Int = 1,
    str: String = "1"
) {
    val next = n + 1
    if (size < next) {
        var number = 0
        var sum = 0
        var isPlus = true
        str.forEach { c ->
            when (c) {
                '+', '-' -> {
                    sum += if (isPlus) number else -number
                    isPlus = c == '+'
                    number = 0
                }

                ' ' -> {
                    number *= 10
                }

                else -> {
                    number += c.digitToInt()
                }
            }
        }
        sum += if (isPlus) number else -number
        if (sum == 0) {
            bw.write("$str\n")
        }
        return
    }
    getAllExpression(size, next, "$str $next")
    getAllExpression(size, next, "$str+$next")
    getAllExpression(size, next, "$str-$next")
}