package date_24_10_7

// nxn , 파이어볼 m
// 파이어볼이 속력만큼 방향으로 이동(이동중 여러개 있어도 됨)
// 2개 이상이라면 하나로 합쳐졌다가 4개로 나뉘어짐
// 나눠진 볼 질량: 합쳐진 파이어볼 질량합/5
// 속력: 속력합/합쳐진 개수
// 방향: 모두 홀수or짝수 0,2,4,6 / 1,3,5,7
// 질량이 0인 파이어볼 소멸

// 출력: k번 명령 후 남아있는 파이어볼 질량의 합
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val wizard = Wizard(n)
    repeat(m) {
        readLine().split(" ").map { it.toInt() }.also {
            val newFireBall = Fireball(it[0] - 1, it[1] - 1, it[2], it[3], it[4])
            wizard.addFireball(newFireBall)
        }
    }

    repeat(k) {
        wizard.magic()
    }

    print(wizard.getTotalWeight())
}

private class Wizard(
    initialMapSize: Int,
) {
    private val mapSize = initialMapSize
    private val fireballs = mutableListOf<Fireball>()

    fun addFireball(fireBall: Fireball) {
        fireballs.add(fireBall)
    }

    fun magic() {
        if (fireballs.isEmpty()) {
            return
        }
        fireballs.forEach {
            it.move(mapSize)
        }

        val fireballMap = Array(mapSize) {
            Array(mapSize) {
                mutableListOf<Fireball>()
            }
        }
        fireballs.forEach { fireballMap[it.y][it.x].add(it) }

        for (i in 0..<mapSize) {
            for (j in 0..<mapSize) {
                val fireballsAtSamePosition = fireballMap[i][j]
                if (fireballsAtSamePosition.size <= 1) continue
                mergeAndSplit(i, j, fireballsAtSamePosition)
                fireballs.removeAll(fireballsAtSamePosition)
            }
        }
    }

    private fun mergeAndSplit(y: Int, x: Int, mergedFireball: List<Fireball>) {
        val weight = mergedFireball.sumOf { it.weight } / 5
        if (weight <= 0) return

        val speed = mergedFireball.sumOf { it.speed } / mergedFireball.size
        val isAllEvenNumber = mergedFireball.all { it.dir % 2 == 0 }
        val isAllOddNumber = mergedFireball.all { it.dir % 2 == 1 }

        val dirs = if (isAllEvenNumber || isAllOddNumber) {
            listOf(0, 2, 4, 6)
        } else {
            listOf(1, 3, 5, 7)
        }

        for (dir in dirs) {
            val newFireball = Fireball(y, x, weight, speed, dir)
            fireballs.add(newFireball)
        }
    }

    fun getTotalWeight(): Int {
        return fireballs.sumOf { it.weight }
    }
}

private class Fireball(
    var y: Int,
    var x: Int,
    val weight: Int,
    val speed: Int,
    val dir: Int,
) {
    private val dy = listOf(-1, -1, 0, 1, 1, 1, 0, -1)
    private val dx = listOf(0, 1, 1, 1, 0, -1, -1, -1)
    fun move(mapSize: Int) {
        y = (y + dy[dir] * (speed % mapSize) + mapSize) % mapSize
        x = (x + dx[dir] * (speed % mapSize) + mapSize) % mapSize
    }
}