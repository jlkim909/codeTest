import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())
    val n = token.nextToken().toInt()
    val k = token.nextToken().toInt()
    val d = Array(200001){
        -1
    }
    d[n] = 0
    val q = ArrayDeque<Int>()
    val MAX = 200001
    q.add(n)
    while(!q.isEmpty()){
        val now = q.removeFirst()
        // 0초 걸리는걸 우선으로 방문해야함
        // *2 칸
        if(now*2 < MAX) {
            if (d[now * 2] == -1) {
                d[now * 2] = d[now]
                q.addFirst(now * 2)
            }
        }
        // -1 칸
        if(now - 1 >= 0){
            if(d[now-1] == -1){
                d[now-1] = d[now] + 1
                q.add(now-1)
            }
        }
        // 1 칸
        if(now + 1 < MAX){
            if(d[now+1] == -1){
                d[now+1] = d[now] + 1
                q.add(now+1)
            }
        }
    }

    print(d[k])
}