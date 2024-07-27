package date_24_7_29

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(n) {
        readLine().toInt()
    }

    arr.sort()

    var gcf = arr[1] - arr[0]

    for (i in 2..<n) {
        gcf = euclidean(gcf, arr[i] - arr[i - 1])
    }

    for (i in 2..gcf) {
        if (gcf % i == 0) {
            print("$i ")
        }
    }
}

private fun euclidean(a: Int, b: Int): Int = when(b){
    0 -> a
    else -> euclidean(b, a%b)
}