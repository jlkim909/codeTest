package date_24_12_9

fun main() = with(System.`in`.bufferedReader()) {
    val (_, _, l, k) = readLine().split(" ").map { it.toInt() }
    val stars = MutableList(k) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        Star(y, x)
    }

    var result = k
    for ((y, _) in stars) {
        for ((_, x) in stars) {
            var starCntInRect = 0
            stars.forEach {
                starCntInRect += inRect(y, x, l, it)
            }
            if(result > k - starCntInRect){
                result = k - starCntInRect
            }
        }
    }

    print(result)
}

private fun inRect(y: Int, x: Int, length: Int, star: Star): Int {
    return if (star.x in x..x + length
        && star.y in y..y + length
    ) 1
    else 0
}

private data class Star(
    val y: Int,
    val x: Int,
)