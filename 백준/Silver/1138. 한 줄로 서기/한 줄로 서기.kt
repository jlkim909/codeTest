package all

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val leftTall = readLine().split(" ").map{it.toInt()}
    fun lineFun(line:MutableList<Int>, isVisited:BooleanArray){
        if(line.size == n){
            for(l in line){
                print("$l ")
            }
            return
        }
        for(i in 1..n){
            if(!isVisited[i]) {
                if (line.count { it > i } == leftTall[i - 1]) {
                    isVisited[i] = true
                    line.add(i)
                    lineFun(line, isVisited)
                }
            }
        }
    }
    val isVisited = BooleanArray(n+1){
        false
    }

    val line = mutableListOf<Int>()

    lineFun(line,isVisited)
}