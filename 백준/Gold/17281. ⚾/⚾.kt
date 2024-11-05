package date_24_10_21

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val resultOfInning = List(n) {
        readLine().split(" ").map { it.toInt() }
    }
    val teamA = BaseballTeam(resultOfInning)
    print(teamA.maxScore)
}

private class BaseballTeam(
    private val inningResultOfPlayer: List<List<Int>>
) {
    private val totalInnings = inningResultOfPlayer.size
    private val base = Array(8) {
        Array(5) {
            Pair(0, 0)
        }
    }

    var maxScore = 0

    init {
        var k = 1
        var score = 0
        for (i in 0..7) {
            if (i == 4) {
                score += 1
            }
            base[i][1] = Pair(k, score)
            k = (k + 2) % 8
        }

        k = 2
        score = 0
        for (i in 0..7) {
            if (i == 2 || i == 6) {
                score += 1
            }
            base[i][2] = Pair(k, score)
            k = (k + 4) % 8
        }

        k = 4
        score = 0
        for (i in 0..7) {
            if (i % 2 == 1) {
                score += 1
            }
            if (i == 4) {
                score -= 1
            }
            base[i][3] = Pair(4, score)
            base[i][4] = Pair(0, score + 1)
        }
        val isVisited = BooleanArray(9)
        allOrderPlay("", isVisited)
    }


    private fun playBaseball(order: String): Int {
        var currentBatterNum = 0
        var score = 0
        repeat(totalInnings) { inning ->
            var outCount = 0
            var baseType = 0
            while (outCount < 3) {
                val batter = order[currentBatterNum].digitToInt()
                val type = inningResultOfPlayer[inning][batter]
                if (type == 0) {
                    outCount += 1
                } else {
                    val (nextBaseType, s) = base[baseType][type]
                    baseType = nextBaseType
                    score += s
                }
                currentBatterNum = (currentBatterNum + 1) % 9
            }
        }
        return score
    }

    fun allOrderPlay(playerOrders: String, isVisited: BooleanArray) {
        if (playerOrders.length >= 8) {
            val newOrder = playerOrders.substring(0, 3) + '0' + playerOrders.substring(3)
            maxScore = maxOf(maxScore, playBaseball(newOrder))
            return
        }
        for (i in 1..8) {
            if (!isVisited[i]) {
                isVisited[i] = true
                allOrderPlay(playerOrders + i, isVisited)
                isVisited[i] = false
            }
        }
    }
}