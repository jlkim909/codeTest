import java.io.BufferedReader
import java.io.InputStreamReader


fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val q = ArrayDeque<Pair<Int,Int>>()
    val s = br.readLine().toInt()
    val d = Array(2001){
        Array<Int>(2001){
            -1
        }
    }
    val MAX = s*2
    q.add(Pair(1,0))
    d[1][0] = 0
    d[0][0] = 0
    // 복사하기
    // 붙여넣기
    // 삭제하기
    val clipBoard = 0
    while(!q.isEmpty()){
        val qItem = q.removeFirst()
        val now = qItem.first
        val clip = qItem.second
        // 복사하기
        if(now < MAX) {
            if (d[now][now] == -1) {
                d[now][now] = d[now][clip] + 1
                q.add(Pair(now, now))
            }
        }
        // 붙여넣기
        if(now+clip < MAX){
            if(d[now+clip][clip] == -1) {
                d[now+clip][clip] = d[now][clip] + 1
                q.add(Pair(now + clip, clip))
            }
        }
        // 삭제하기
        if(now - 1 > 0){
            if(d[now-1][clip] == -1){
                d[now-1][clip] = d[now][clip] + 1
                q.add(Pair(now-1,clip))
            }
        }
    }

    var result = 10000001
    for(i in 1..2000){
        if(d[s][i] == -1) continue
        if(result > d[s][i]){
            result = d[s][i]
        }
    }
    print(result)
}