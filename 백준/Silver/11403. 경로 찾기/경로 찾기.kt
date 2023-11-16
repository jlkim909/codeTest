package Graph

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val g = Array(n){
        val st = StringTokenizer(readLine())
        BooleanArray(n){
            st.nextToken().toInt() == 1
        }
    }


    fun dfs(s:Int, e:Int, isVisited:Array<BooleanArray>):Boolean{
        for (i in 0 until n) {
            if (g[s][i] && !isVisited[s][i]) {
                isVisited[s][i] = true
                if(i == e) return true
                if(dfs(i, e, isVisited)){
                    return true
                }
            }
        }
        return false
    }


    for(i in 0 until n){
        for(j in 0 until n){
            val isVisited = Array(n) {
                BooleanArray(n) {
                    false
                }
            }
            if(dfs(i,j,isVisited)) {
                print("1 ")
            } else print("0 ")
        }
        println()
    }
}