package date_24_11_25

fun main() = with(System.`in`.bufferedReader()) {
    val (n, r, c) = readLine().split(" ").map { it.toInt() }

    print(findNumber(n, r, c))
}

fun findNumber(n: Int, r: Int, c: Int): Int {
    if (n <= 1) {
        return if (r > 0 && c > 0) {
            3
        } else if (r > 0) {
            2
        } else if (c > 0) {
            1
        } else {
            0
        }
    }

    val p = 1.shl(n - 1)
    return if (p <= r && p <= c) {
        1.shl(n - 2) * 3 * 1.shl(n) + findNumber(n - 1, r - p, c - p)
    } else if (p <= r) {
        1.shl(n - 2) * 2 * 1.shl(n) + findNumber(n - 1, r - p, c)
    } else if (p <= c) {
        1.shl(n - 2) * 1.shl(n) + findNumber(n - 1, r, c - p)
    } else {
        findNumber(n - 1, r, c)
    }
}