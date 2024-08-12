package date_24_8_12

fun main() = with(System.`in`.bufferedReader()) {
    val arr = mutableListOf<Int>()
    val d = IntArray(1_000_001)

    arr.add(1)

    var idx = 1
    var t = 5
    while (true) {
        if(arr.last() > 1_000_001){
            break
        }
        d[arr.last()] = 1
        arr.add(arr.last() + t)
        t += 4
        idx += 1
    }

    fun dp(n: Int): Int {
        if (n == 0) {
            return 0
        }

        if (n == 1) {
            return 1
        }

        if (d[n] != 0) {
            return d[n]
        }

        var k = 0
        var minNum = 6
        while (arr[k] < n) {
            val num = arr[k]
            var multiple = 1
            if(n/num <= 6) {
                while (num * multiple < n) {
                    val first = num * multiple
                    val temp = dp(num) * multiple + dp(n - first)
                    if (minNum > temp) {
                        minNum = temp
                    }
                    multiple += 1
                }
            }

            k += 1
        }

        d[n] = minNum

        return d[n]
    }

    val n = readLine().toInt()

    print(dp(n))
}