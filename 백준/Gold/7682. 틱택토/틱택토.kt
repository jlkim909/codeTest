package date_24_11_13

val isValidTicTacToe = BooleanArray(20000)
val isVisited = BooleanArray(20000)
fun main() = with(System.`in`.bufferedReader()) {
    tictactoe()
    val bw = System.out.bufferedWriter()
    while (true) {
        val board = readLine()
        if (board == "end") {
            break
        }
        val key = getKey(board.toCharArray())
        if (isValidTicTacToe[key]) {
            bw.write("valid\n")
        } else {
            bw.write("invalid\n")
        }
    }
    bw.flush()
    bw.close()
}

var cnt = 0
@Suppress("SpellCheckingInspection")
private fun tictactoe(state: CharArray = CharArray(9) { '.' }, current: Char = 'X') {
    val key = getKey(state)
    if (isVisited[key]) {
        return
    }

    isVisited[key] = true
    isValidTicTacToe[key] = checkValid(state)
    if(isValidTicTacToe[key]){
        return
    }
    for (i in 0..8) {
        if (state[i] != '.') {
            continue
        }
        state[i] = current
        val next = if (current == 'X') 'O' else 'X'
        tictactoe(state, next)
        state[i] = '.'
    }
}

private fun getKey(state: CharArray): Int {
    var key = 0
    var k = 1
    state.forEach {
        when (it) {
            'X' -> {
                key += k
            }

            'O' -> {
                key += 2 * k
            }
        }
        k *= 3
    }

    return key
}

private fun checkValid(state: CharArray): Boolean {
    var checkDot = false
    for (c in state) {
        if (c == '.') {
            checkDot = true
        }
    }

    if (!checkDot) {
        return true
    }

    val threePoint = mutableListOf<String>()
    repeat(3) {
        threePoint.add("${state[it * 3]}${state[it * 3 + 1]}${state[it * 3 + 2]}")
        threePoint.add("${state[it]}${state[it + 3]}${state[it + 6]}")
    }
    threePoint.add("${state[0]}${state[4]}${state[8]}")
    threePoint.add("${state[2]}${state[4]}${state[6]}")

    var check = false
    for (tp in threePoint) {
        if (tp == "OOO" || tp == "XXX") {
            check = true
            break
        }
    }

    return check
}