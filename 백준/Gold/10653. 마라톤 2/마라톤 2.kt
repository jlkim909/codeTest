package All

import java.util.StringTokenizer
import kotlin.math.abs

private const val INF = 1_000_000_000
private data class P(val y:Int, val x:Int)
private val d = Array(501){
    Array(501){
        -1
    }
}

private lateinit var map:Array<P>
fun main() = with(System.`in`.bufferedReader()){
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    map = Array(n){
        st = StringTokenizer(readLine())
        P(st.nextToken().toInt()+1000, st.nextToken().toInt()+1000)
    }
    val isVisited = Array(n){
        false
    }
    isVisited[n-1] = true
    print(manhattan(n,n-1,n-k, isVisited))
}

private fun manhattan(n:Int, cn:Int, k:Int, isVisit:Array<Boolean>):Int{
    if(k <= 2){
        return abs(map[cn].y - map[0].y) + abs(map[cn].x - map[0].x)
    }
    if(d[cn][k] != -1){
        return d[cn][k]
    }
    var min = INF
    for(i in 1 until cn){
        if(isVisit[i]) continue
        val distance = abs(map[cn].y - map[i].y) + abs(map[cn].x - map[i].x)
        isVisit[i] = true
        val temp = manhattan(n, i, k-1, isVisit) + distance
        if(temp < min){
            min = temp
        }
        isVisit[i] = false
    }
    d[cn][k] = min
    return min
}