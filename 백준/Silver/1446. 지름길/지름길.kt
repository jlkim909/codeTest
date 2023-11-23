package All

fun main() = with(System.`in`.bufferedReader()){
    data class ShortCut(val end:Int, val d:Int)
    val (n, d) = readLine().split(" ").map{it.toInt()}
    val shortCut = Array(10001){
        mutableListOf<ShortCut>()
    }
    repeat(n){
        val (s, e, distance) = readLine().split(" ").map{it.toInt()}
        shortCut[e].add(ShortCut(s,distance))
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
        return min
    }
    print(drive(d, 0))
}