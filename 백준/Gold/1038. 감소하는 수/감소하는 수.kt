package date_24_7_24

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = mutableListOf<Long>()
    fun backTracking(idx: Int, k: Long, current: Long) {
        var num = current
        for (i in idx..9) {
            num += i * k
            arr.add(num)
            backTracking(i + 1, k * 10, num)
            num -= i * k
        }
    }

    backTracking(0, 1, 0)
    if(arr.size -1 <n){
        print(-1)
        return
    }

    arr.sort()
    print(arr[n])
}