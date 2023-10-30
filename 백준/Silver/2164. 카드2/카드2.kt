package DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val dq = ArrayDeque<Int>()
    repeat(n){
        dq.add(it)
    }
    while(true){
        if(dq.size == 1) break
        dq.removeFirst()
        if(dq.size == 1) break
        dq.add(dq.removeFirst())
    }
    print(dq.removeFirst()+1)
}