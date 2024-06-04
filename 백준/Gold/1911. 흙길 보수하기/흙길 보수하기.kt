package all

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, l) = readLine().split(" ").map { it.toInt() }
    val puddles = PriorityQueue<Pair<Int, Int>> { s1, s2 ->
        s1.first.compareTo(s2.first)
    }
    repeat(n) {
        val (s, e) = readLine().split(" ").map { it.toInt() }
        puddles.add(Pair(s, e))
    }

    var start = 0
    var result = 0
    while(puddles.isNotEmpty()){
        val (s,e) = puddles.poll()
        if(start < s) {
            start = s
        }
        while(start < e){
            start += l
            result += 1
        }
    }

    print(result)
}