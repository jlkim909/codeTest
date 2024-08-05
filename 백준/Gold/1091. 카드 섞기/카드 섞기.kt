package date_24_8_5

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val p = readLine().split(" ").map { it.toInt() }
    val s = readLine().split(" ").map { it.toInt() }

    val start = IntArray(n) {
        it
    }

    val player = Array(3) {
        mutableListOf<Int>()
    }
    for (i in 0..<n) {
        player[p[i]].add(start[i])
    }

    fun checkCards(cards:IntArray):Boolean{
        for(i in 0..<n){
            if(!player[i%3].contains(cards[i])){
                return false
            }
        }

        return true
    }

    fun checkSame(a: IntArray, b: IntArray): Boolean {
        for (i in 0..<n) {
            if (a[i] != b[i]) {
                return false
            }
        }
        return true
    }

    fun shuffleCards(a:IntArray):IntArray{
        val newCards = IntArray(n)

        for(i in 0..<n){
            newCards[s[i]] = a[i]
        }

        return newCards
    }

    var result = 0
    var cards = start
    var k = 0
    while (true) {
        if (checkCards(cards)) {
            break
        }

        if(result > 0 && checkSame(start, cards)){
            result = -1
            break
        }

        cards = shuffleCards(cards)
        result += 1
        k += 1
    }

    print(result)
}