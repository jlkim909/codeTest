package all

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var buildings = mutableListOf<Int>()

    var k = 0
    repeat(n) {
        k += 1
        val (_, height) = readLine().split(" ").map { it.toInt() }
        buildings.add(height)
    }

    val isVisited = BooleanArray(500_001)
    var result = 0
    var currentHeight = 0
    isVisited[0] = true
    for (h in buildings) {
        if (currentHeight < h) {
            result += 1
            isVisited[h] = true
        } else {
            if (!isVisited[h]) {
                result += 1
                isVisited[h] = true
            }
            for(i in h + 1..currentHeight){
                isVisited[i] = false
            }
        }

        currentHeight = h
    }

    print(result)

}