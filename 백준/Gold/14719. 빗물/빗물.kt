package all

fun main() = with(System.`in`.bufferedReader()) {
    val (h, w) = readLine().split(" ").map { it.toInt() }
    var blocks = readLine().split(" ").map { it.toInt() }.toMutableList()

    while (blocks.isNotEmpty() && blocks.first() == 0) {
        blocks.removeFirst()
    }

    while (blocks.isNotEmpty() && blocks.last() == 0) {
        blocks.removeLast()
    }

    var result = 0
    while(true) {
        if(blocks.size < 3){
            break
        }
        var end = blocks.size - 1
        val leftTop = blocks[0]
        var sum = 0
        for (i in 1..end) {
            if (leftTop > blocks[i]) {
                sum += blocks[i]
            } else {
                result += leftTop * (i - 1) - sum
                blocks = blocks.slice(i..end).toMutableList()
                break
            }
        }

        if(blocks.size < 3){
            break
        }

        end = blocks.size - 1
        val rightTop = blocks[end]
        sum = 0
        for (i in end - 1 downTo 0) {
            if (rightTop > blocks[i]) {
                sum += blocks[i]
            } else {
                result += rightTop * (end - i - 1) - sum
                blocks = blocks.slice(0..i).toMutableList()
                break
            }
        }
    }

    print(result)
}