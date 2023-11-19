package Graph

fun main() = with(System.`in`.bufferedReader()){
    val nm = readLine().split(" ").map{it.toInt()}
    val n = nm[0]
    val m = nm[1]

    data class Room(val n:Int, val d:Int)

    val g = Array(n+1){
        mutableListOf<Int>()
    }
    repeat(m){
        val ab = readLine().split(" ").map{it.toInt()}
        g[ab[0]].add(ab[1])
        g[ab[1]].add(ab[0])
    }

    val dq = ArrayDeque<Room>()
    val isVisited = IntArray(n+1){
        -1
    }
    dq.add(Room(1,0))
    isVisited[1] = 0
    while(!dq.isEmpty()){
        val c = dq.removeFirst()
        val rn = c.n
        val d = c.d
        for(i in g[rn]){
            if(isVisited[i] == -1){
                isVisited[i] = d + 1
                dq.add(Room(i, d + 1))
            }
        }
    }

    var resultDistance = 0
    for(i in 1..n){
        if(isVisited[i] > resultDistance){
            resultDistance = isVisited[i]
        }
    }

    var roomNum = 0
    var roomCnt = 0
    for(i in 1..n){
        if(resultDistance == isVisited[i]){
            if(roomNum == 0){
                roomNum = i
            }
            roomCnt++
        }
    }

    print("$roomNum $resultDistance $roomCnt")
}