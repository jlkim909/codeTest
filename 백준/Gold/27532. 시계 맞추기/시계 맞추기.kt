package date_25_01_19

fun main() = with(System.`in`.bufferedReader()) {
    val m = readLine().toInt()
    val times = mutableListOf<Int>()
    repeat(m) {
        times.add(timeToMinute(readLine()))
    }
    var result = m
    for (r in 1..720) {
        val newTimes = mutableSetOf<Int>()
        for (i in 0..<m) {
            val min = (720 * i + times[i] - r * i) % 720
            newTimes.add(min)
        }
        result = minOf(result, newTimes.size)
    }

    println(result)
}

private fun timeToMinute(time: String): Int {
    val (hour, minute) = time.split(":").map { it.toInt() }
    return (hour % 12) * 60 + minute
}