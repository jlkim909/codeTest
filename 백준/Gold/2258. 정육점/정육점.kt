package all

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val meets = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (weight, price) = readLine().split(" ").map { it.toInt() }
        meets.add(Pair(weight, price))
    }

    meets.sortWith { s1, s2 ->
        if (s1.second != s2.second) {
            s1.second - s2.second
        } else {
            s2.first - s1.first
        }
    }

    var sum = 0
    var previousPrice = 0
    var totalPrice = 0
    var result = -1
    var several = false
    while (meets.isNotEmpty()) {
        val (w, p) = meets.removeFirst()
        sum += w
        if (previousPrice == p) {
            totalPrice += p
            if (sum >= m && !several) {
                several = true
                result = totalPrice
            }
        } else {
            previousPrice = p
            several = false
            if (sum >= m) {
                if(result == -1){
                    result = p
                } else {
                    if (p < result) {
                        result = p
                    }
                }
            }
            totalPrice = p
        }
    }

    if (sum < m) {
        print(-1)
    } else {
        print(result)
    }
}