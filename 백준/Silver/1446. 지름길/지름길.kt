package All

fun main() = with(System.`in`.bufferedReader()){
    data class Drive(val p:Int, val d:Int)
    data class ShortCut(val end:Int, val d:Int)
    val (n, end) = readLine().split(" ").map{it.toInt()}
    val dq = ArrayDeque<Drive>()
    val shortCut = Array(10001){
        mutableListOf<ShortCut>()
    }
    repeat(n){
        val (s, e, d) = readLine().split(" ").map{it.toInt()}
        shortCut[e].add(ShortCut(s,d))
    }

    val memo = IntArray(10_001){
        -1
    }
    fun drive(e:Int, d:Int):Int{
        if(e == 0){
            return d
        }
        if(e < 0){
            return 10001
        }
        var min = 10001
        min = minOf(min,drive(e-1, d+1))
        for((next, distance) in shortCut[e]){
            min = minOf(min,drive(next, d+distance))
        }
        memo[d] = min
        return memo[d]
    }
    print(drive(end, 0))
}