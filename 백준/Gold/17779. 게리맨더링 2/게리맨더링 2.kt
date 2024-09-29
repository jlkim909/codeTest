package date_24_9_30

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = Array(n + 1) {
        IntArray(n + 1)
    }
    for (i in 1..n) {
        val inp = readLine().split(" ").map { it.toInt() }
        for (j in 1..n) {
            map[i][j] = inp[j - 1]
        }
    }

    var result = Int.MAX_VALUE
    for (d1 in 1..n) {
        for (d2 in 1..n) {
            for (y in 1..n) {
                for (x in 1..n) {
                    if (x + d1 + d2 > n) continue
                    if (y - d1 < 1) continue
                    if (y + d2 > n) continue

                    val west = Pair(y, x)
                    val north = Pair(y - d1, x + d1)
                    val east = Pair(y - d1 + d2, x + d1 + d2)
                    val south = Pair(y + d2, x + d2)

                    val area = Array(n + 1) {
                        IntArray(n + 1)
                    }

                    var startX = north.second
                    var endX = north.second
                    var checkWest = false
                    var checkEast = false

                    for (i in north.first..south.first) {
                        if (i == west.first && startX == west.second) {
                            checkWest = true
                        }

                        if (i == east.first && endX == east.second) {
                            checkEast = true
                        }
                        for (j in startX..endX) {
                            area[i][j] = 5
                        }
                        if (checkWest) {
                            startX += 1
                        } else {
                            startX -= 1
                        }

                        if (checkEast) {
                            endX -= 1
                        } else {
                            endX += 1
                        }
                    }

                    var ny = 1
                    var nx = 1
                    while (ny < west.first) {
                        if (area[ny][nx] == 5 || nx > north.second) {
                            nx = 1
                            ny += 1
                            continue
                        }
                        area[ny][nx] = 1
                        nx += 1
                    }

                    ny = 1
                    nx = n

                    while (ny <= east.first) {
                        if (area[ny][nx] == 5 || nx <= north.second) {
                            nx = n
                            ny += 1
                            continue
                        }

                        area[ny][nx] = 2
                        nx -= 1
                    }

                    ny = n
                    nx = 1

                    while (ny >= west.first) {
                        if (area[ny][nx] == 5 || nx >= south.second) {
                            nx = 1
                            ny -= 1
                            continue
                        }
                        area[ny][nx] = 3
                        nx += 1
                    }

                    ny = n
                    nx = n
                    while (ny > east.first) {
                        if (area[ny][nx] == 5 || nx < south.second) {
                            nx = n
                            ny -= 1
                            continue
                        }
                        area[ny][nx] = 4
                        nx -= 1
                    }
                    val peopleNum = IntArray(5)
                    for (i in 1..n) {
                        for (j in 1..n) {
                            peopleNum[area[i][j] - 1] += map[i][j]
                        }
                    }

                    result = minOf(result, peopleNum.max() - peopleNum.min())
                }
            }
        }
    }

    print(result)
}