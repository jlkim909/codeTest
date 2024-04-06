package all

fun main() = with(System.`in`.bufferedReader()) {
    data class ConveyorBelt(var durability: Int, var robotNum: Int)

    val (n, k) = readLine().split(" ").map { it.toInt() }
    fun rotateConveyorBelt(
        conveyorBelt: MutableList<ConveyorBelt>
    ): MutableList<ConveyorBelt> {
        val temp = mutableListOf<ConveyorBelt>()
        temp.add(conveyorBelt[2*n-1])
        temp += conveyorBelt.slice(0..<conveyorBelt.size-1)
        return temp
    }
    var conveyorBelt = readLine().split(" ")
        .map { ConveyorBelt(it.toInt(), 0) }
        .toMutableList()
    var result = 0
    while (true) {
        // 단계 + 1
        result += 1

        // 회전
        conveyorBelt = rotateConveyorBelt(conveyorBelt)
        // 회전 후 로봇 내림
        conveyorBelt[n-1].robotNum = 0

        // 로봇 이동
        for (i in n - 2 downTo 0) {
            if (conveyorBelt[i + 1].durability == 0 ||
                conveyorBelt[i + 1].robotNum != 0
            ) {
                continue
            }

            if (conveyorBelt[i + 1].durability >= conveyorBelt[i].robotNum) {
                conveyorBelt[i + 1].durability -= conveyorBelt[i].robotNum
                conveyorBelt[i + 1].robotNum = conveyorBelt[i].robotNum
                conveyorBelt[i].robotNum = 0
            } else {
                conveyorBelt[i].robotNum -= conveyorBelt[i + 1].durability
                conveyorBelt[i + 1].robotNum = conveyorBelt[i + 1].durability
                conveyorBelt[i + 1].durability = 0
            }
        }

        // 로봇 이동 후 로봇 내림
        conveyorBelt[n-1].robotNum = 0

        // 로봇 탑승
        if(conveyorBelt[0].durability != 0){
            conveyorBelt[0].durability -= 1
            conveyorBelt[0].robotNum += 1
        }

        // 내구도 0인 벨트 계산
        var sum = 0
        for((durability,_) in conveyorBelt){
            if(durability == 0){
                sum+=1
            }
        }
        
        if(k <= sum){
            break
        }
    }

    print(result)
}