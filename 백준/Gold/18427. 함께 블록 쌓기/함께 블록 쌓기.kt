package data_24_12_15

private lateinit var students: Array<List<Int>>
private lateinit var block: Array<IntArray>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, h) = readLine().split(" ").map { it.toInt() }
    students = Array(n) {
        emptyList<Int>()
    }
    block = Array(n) {
        IntArray(h + 1) { -1 }
    }
    repeat(n) {
        students[it] = readLine().split(" ").map { it.toInt() }
    }

    print(buildBlock(n - 1, h))
}

private fun buildBlock(n: Int, h: Int): Int {
    if (h < 0) {
        return 0
    }

    if (n < 0) {
        return if(h == 0){
            1
        }else{
            0
        }
    }


    if (block[n][h] != -1) {
        return block[n][h]
    }

    var allKind = buildBlock(n - 1, h)
    for (height in students[n]) {
        allKind += buildBlock(n - 1, h - height)
        allKind %= 10_007
    }

    block[n][h] = allKind

    return block[n][h]
}