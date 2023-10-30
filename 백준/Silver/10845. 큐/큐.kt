package DataStructure

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val dq = ArrayDeque<Int>()
    val e = 1_000_000_000
    repeat(n){
        val st = StringTokenizer(br.readLine())
        val p = when(st.nextToken()){
            "push" -> {
                dq.add(st.nextToken().toInt())
                e
            }
            "pop" -> if(dq.isEmpty()) -1 else dq.removeFirst()
            "front" -> if(dq.isEmpty()) -1 else dq.first()
            "back" -> if(dq.isEmpty()) -1 else dq.last()
            "size" -> dq.size
            "empty" -> if(dq.isEmpty()) 1 else 0
            else -> e
        }
        if(p != e) bw.write("$p\n")
    }
    bw.flush()
    bw.close()
}