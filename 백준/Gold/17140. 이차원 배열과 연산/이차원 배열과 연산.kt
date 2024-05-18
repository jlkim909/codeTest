package all

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c, k) = readLine().split(" ").map { it.toInt() }
    val a = Array(200) {
        IntArray(200)
    }

    repeat(3) {
        readLine().split(" ").map { it.toInt() }.forEachIndexed { idx, num ->
            a[it][idx] = num
        }
    }

    fun sortOfProblem(list: MutableList<Int>): MutableList<Int> {
        val pq = PriorityQueue<Pair<Int, Int>> { s1, s2 ->
            val secondComparison = s1.second.compareTo(s2.second)
            if (secondComparison != 0) {
                secondComparison
            } else {
                s1.first.compareTo(s2.first)
            }
        }

        list.sort()
        var startNum = list[0]
        var cnt = 0

        for (num in list) {
            if (num == startNum) {
                cnt += 1
            } else {
                pq.add(Pair(startNum, cnt))
                startNum = num
                cnt = 1
            }
        }

        pq.add(Pair(startNum, cnt))

        val newList = mutableListOf<Int>()
        while (pq.isNotEmpty()) {
            val (f, s) = pq.poll()
            newList.add(f)
            newList.add(s)
        }

        return newList
    }

    var time = 0
    var maxRow = 3
    var maxCol = 3

    while (time <= 100) {
        if (a[r-1][c-1] == k) {
            print(time)
            return
        }
        if (maxRow >= maxCol) {
            for (row in 0..<maxRow) {
                val newRow = sortOfProblem(a[row].filter { it != 0 }.toMutableList())
                if(maxCol < newRow.size){
                    maxCol = newRow.size
                }
                a[row] = IntArray(200)
                for(i in 0..<newRow.size){
                    a[row][i] = newRow[i]
                }
            }
        } else {
            for(col in 0..<maxCol){
                val columnList = mutableListOf<Int>()
                for(row in 0..<maxRow){
                    if(a[row][col] != 0) {
                        columnList.add(a[row][col])
                        a[row][col] = 0
                    }
                }
                val newCol = sortOfProblem(columnList)
                if(maxRow < newCol.size){
                    maxRow = newCol.size
                }
                for(i in 0..<newCol.size){
                    a[i][col] = newCol[i]
                }
            }
        }

        time += 1
    }

    print(-1)
}

