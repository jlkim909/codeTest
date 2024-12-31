package date_25_01_05

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val towns = Array(n) {
        mutableListOf<Town>()
    }

    repeat(m) {
        val (from, to, cost) = readLine().split(" ").map { it.toInt() }
        towns[from - 1].add(Town(to - 1, cost))
        towns[to - 1].add(Town(from - 1, cost))
    }

    val isVisited = BooleanArray(n)
    val pq = PriorityQueue<Town> { l1, l2 ->
        l1.cost.compareTo(l2.cost)
    }

    isVisited[0] = true

    towns[0].forEach {
        pq.add(it)
    }

    var maxCost = 0
    var result = 0
    while (pq.isNotEmpty()) {
        val (next, cost) = pq.poll()
        if (isVisited[next]) continue
        result += cost
        maxCost = maxOf(cost, maxCost)
        isVisited[next] = true
        towns[next].forEach {
            if (!isVisited[it.num]) {
                pq.add(it)
            }
        }
    }

    print(result - maxCost)
}

data class Town(
    val num: Int,
    val cost: Int,
)