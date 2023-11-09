package greedy

fun main() = with(System.`in`.bufferedReader()){
    data class Line(val start:Int, val end:Int)
    val INF = 1_000_000_000
    val n = readLine().toInt()
    val p = Array(n){
        val line = readLine().split(" ").map{it.toInt()}
        Line(line[0]+INF, line[1]+INF)
    }
    p.sortBy{it.start}
    var result = 0L
    var start = p[0].start
    var end = p[0].end
    for(i in 1 until n){
        if(end >= p[i].start){
            if(end < p[i].end) {
                end = p[i].end
            }
        }else{
            result+= end-start
            start = p[i].start
            end = p[i].end
        }
    }
    result+= end-start
    print(result)
}