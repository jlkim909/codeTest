package BFSDFS

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val g = Array(n+1){
        mutableListOf<Int>()
    }
    repeat(m){
        st = StringTokenizer(br.readLine())
        val p1 = st.nextToken().toInt()
        val p2 = st.nextToken().toInt()
        g[p1].add(p2)
        g[p2].add(p1)
    }
    var fc = 101
    var result = 1
    for(i in 1..n){
        val isVisited = Array(n+1){
            -1
        }
        isVisited[i] = 0
        val dq = ArrayDeque<Int>()
        dq.add(i)
        while(!dq.isEmpty()){
            val p = dq.removeFirst()
            for(i in g[p]){
                if(isVisited[i] == -1){
                    dq.add(i)
                    isVisited[i] = isVisited[p]+1
                }
            }
        }
        var sum = 0
        for(i in 1..n){
            if(isVisited[i] != -1){
                sum+=isVisited[i]
            }
        }
        if(sum < fc){
            fc = sum
            result = i
        }
    }
    print(result)
}