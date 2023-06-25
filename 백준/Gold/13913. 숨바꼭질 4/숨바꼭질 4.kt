import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val q = ArrayDeque<Int>()
    val token = StringTokenizer(br.readLine())
    val n = token.nextToken().toInt()
    val k = token.nextToken().toInt()
    val d = Array<Int>(2*maxOf(n,k,10)){
        -1
    }
    val from = Array<Int>(2*maxOf(n,k,10)){
        0
    }
    val MAX = 2*k
    q.add(n)
    d[n] = 0
    while(!q.isEmpty()){
        val now = q.removeFirst()
        if(now + 1 < MAX){
            if(d[now+1] == -1) {
                q.add(now + 1)
                d[now + 1] = d[now] + 1
                from[now + 1] = now
            }
        }

        if(now - 1 >= 0){
            if(d[now-1] == -1) {
                q.add(now - 1)
                d[now - 1] = d[now] + 1
                from[now-1] = now
            }
        }

        if(now * 2 < MAX){
            if(d[now*2] == -1) {
                q.add(now*2)
                d[now*2] = d[now] + 1
                from[now*2] = now
            }
        }
    }

    val stc = Stack<Int>()
    println(d[k])
    var temp:Int = k
    stc.push(k)
    repeat(d[k]){
        temp = from[temp]
        stc.push(temp)
    }
    while(!stc.isEmpty()){
        print("${stc.pop()} ")
    }
}