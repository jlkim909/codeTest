package all

fun main() = with(System.`in`.bufferedReader()) {
    val number = arrayOf(
        "1110111",
        "0010010",
        "1011101",
        "1011011",
        "0111010",
        "1101011",
        "1101111",
        "1010010",
        "1111111",
        "1111011"
    )

    val switchNumAtoB = Array(10) {
        IntArray(10)
    }

    for (i in 0..9) {
        for (j in 0..9) {
            var sum = 0
            for (k in 0..6) {
                if (number[i][k] != number[j][k]) {
                    sum += 1
                }
            }
            switchNumAtoB[i][j] = sum
        }
    }

    val (n, k, p, x) = readLine().split(" ").map { it.toInt() }

    val currentFloor = "0".repeat(k - x.toString().length) + x.toString()
    var result = 0
    for (i in 1..n) {
        if(i == x){
            continue
        }
        val sn = i.toString()
        val stringNumber = "0".repeat(k - sn.length) + sn
        var sum = 0
        for (j in 0..<k) {
            sum += switchNumAtoB[currentFloor[j].digitToInt()][stringNumber[j].digitToInt()]
        }
        if (sum <= p) {
            result += 1
        }
    }

    print(result)
}