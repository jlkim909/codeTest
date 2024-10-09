package date_24_10_7

// x의 배수인 원판을 d방향(0=시계, 1=반시계)으로 k칸 회전
// 인접한 수 중 같은 수를 찾는다
// 찾음: 모두 지운다
// 못찾음: 원판의 편균을 구해 평균보다 큰 수에서 1을 빼서 작은수에 1을 더한다

// T번 회전 후 원판에 적힌 수의 합을 구한다.

// 4 뒤로 3번 -> 앞으로 1번
// 4 뒤로 7번 -> 앞으로 1번

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, t) = readLine().split(" ").map { it.toInt() }
    val discStack = DiscStack(n, m)
    repeat(n) { idx ->
        val numbers = readLine().split(" ").map { it.toInt() }
        val disc = Disc(numbers)
        discStack.addDisc(disc)
    }

    repeat(t) {
        val (x, d, k) = readLine().split(" ").map { it.toInt() }
        discStack.turn(x, d, k)
    }

    print(discStack.getSum())
}

private class DiscStack(
    initialSize: Int,
    initialNumberCntOfDisc: Int
) {
    private val size = initialSize
    private val discs = mutableListOf<Disc>()
    private val numberCntOfDisc = initialNumberCntOfDisc

    fun addDisc(disc: Disc) {
        discs.add(disc)
    }

    fun getSum(): Int {
        var sum = 0
        discs.forEach {
            sum += it.sumOfNumber()
        }
        return sum
    }

    private fun getLeftNumberCnt(): Int {
        var sum = 0
        discs.forEach {
            sum += it.leftNumberCnt
        }
        return sum
    }

    fun turn(x: Int, d: Int, k: Int) {
        for (i in x - 1..<size step x) {
            if (d == 0) {
                discs[i].rotateRight(k % numberCntOfDisc)
            } else {
                discs[i].rotateLeft(k % numberCntOfDisc)
            }
        }
        val deletePosition = findDeleteNumbers()
        if (deletePosition.isEmpty()) {
            val average = getSum() / getLeftNumberCnt().toDouble()
            discs.forEach {
                it.closeAverage(average)
            }
        } else {
            deletePosition.forEach { (i, j) ->
                discs[i].deleteNumber(j)
            }
        }
    }

    private fun findDeleteNumbers(): List<Pair<Int, Int>> {
        val position = mutableListOf<Pair<Int, Int>>()
        for (i in 0..<size) {
            for (j in 0..<numberCntOfDisc) {
                val currentNum = discs[i].at(j)
                if (currentNum == 0) continue
                val top = if (i + 1 < size) discs[i + 1].at(j) else 0
                val bottom = if (i - 1 >= 0) discs[i - 1].at(j) else 0
                val left = discs[i].at(j - 1)
                val right = discs[i].at(j + 1)
                val isSameNumber =
                    top == currentNum || left == currentNum || right == currentNum || bottom == currentNum
                if (isSameNumber) {
                    position.add(Pair(i, j))
                }
            }
        }
        return position
    }
}

private class Disc(
    initialNumbers: List<Int>
) {
    private var numbers = initialNumbers.toMutableList()
    var leftNumberCnt = initialNumbers.size
        private set

    fun rotateRight(time: Int) {
        repeat(time) {
            numbers.add(0, numbers.removeLast())
        }
    }

    fun rotateLeft(time: Int) {
        repeat(time) {
            numbers.add(numbers.removeFirst())
        }
    }

    fun at(idx: Int): Int {
        return if (idx < 0) {
            numbers.last()
        } else if (idx >= numbers.size) {
            numbers[0]
        } else {
            numbers[idx]
        }
    }

    fun deleteNumber(idx: Int) {
        numbers[idx] = 0
        leftNumberCnt -= 1
    }

    fun closeAverage(num: Double) {
        for (i in 0..<numbers.size) {
            if (numbers[i] == 0) continue
            if (numbers[i] > num) {
                numbers[i] = numbers[i] - 1
            } else if (numbers[i] < num) {
                numbers[i] = numbers[i] + 1
            }
        }
    }

    fun sumOfNumber(): Int {
        return numbers.sum()
    }
}