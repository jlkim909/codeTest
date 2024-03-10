package greedy

fun main() = with(System.`in`.bufferedReader()) {
    val board = readLine()
    var k = 0
    var result = ""
    var cnt = 0

    for (i in board) {
        if (i == 'X') {
            cnt += 1
            if (cnt == 4) {
                result += "AAAA"
                cnt = 0
            }
        } else {
            if (cnt == 2) {
                result += "BB"
                cnt = 0
            } else if(cnt != 0){
                print(-1)
                return
            }
            result += '.'
        }
    }

    if (cnt == 2) {
        result += "BB"
    } else if (cnt != 0) {
        print(-1)
        return
    }

    print(result)
}