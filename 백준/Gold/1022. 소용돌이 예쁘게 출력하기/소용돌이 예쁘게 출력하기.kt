package date_24_8_12

fun main() = with(System.`in`.bufferedReader()) {
    val dy = listOf(0, -1, 0, 1)
    val dx = listOf(1, 0, -1, 0)
    val (r1, c1, r2, c2) = readLine().split(" ").map { it.toInt() }

    var cr = -r1
    var cc = -c1

    var num = 1
    var k = 0
    var dir = 0
    val map = Array(r2 - r1 + 1) {
        IntArray(c2 - c1 + 1)
    }

    var maxNum = 0
    while (true) {
        if (dir % 2 == 0) {
            k += 1
        }
        repeat(k) {
            if (cr in 0..r2 - r1 && cc in 0..c2 - c1) {
                map[cr][cc] = num
                if(maxNum < num){
                    maxNum = num
                }
            }
            num += 1
            cr += dy[dir]
            cc += dx[dir]
        }
        dir = (dir + 1) % 4
        if (map[0][0] != 0 && map[r2 - r1][0] != 0
            && map[0][c2 - c1] != 0 && map[r2 - r1][c2 - c1] != 0
        ) {
            break
        }
    }

    for (i in 0..r2 - r1) {
        for (j in 0..c2 - c1) {
            print("${map[i][j].toString().padStart(maxNum.toString().length, ' ')} ")
        }
        println()
    }
}