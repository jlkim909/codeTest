package greedy

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()){
    data class Lecture(val start:Int, val end:Int)
    val n = readLine().toInt()
    val room = PriorityQueue<Int>()

    val timeArr = Array<Lecture>(n){
        val t = readLine().split(" ").map{ it.toInt() }
        Lecture(t[0], t[1])
    }

    timeArr.sortBy{it.start}

    room.add(timeArr[0].end)
    for(i in 1 until n){
        if(room.peek() <= timeArr[i].start){
            room.poll()
            room.add(timeArr[i].end)
        }else{
            room.add(timeArr[i].end)
        }
    }
    print(room.size)
}