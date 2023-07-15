import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t1 = StringTokenizer(br.readLine())
    val n = t1.nextToken().toInt()
    val m = t1.nextToken().toInt()
    val dy = arrayOf(1,-1,0,0)
    val dx = arrayOf(0,0,-1,1)
    data class P(val y:Int, val x:Int)
    val arr = Array(n){
        Array(m){
            0
        }
    }

    for(i in 0 until n){
        val t1 = StringTokenizer(br.readLine())
        for(j in 0 until m){
            arr[i][j] = t1.nextToken().toInt()
        }
    }
    var result = 0
    while(true){
        val q = ArrayDeque<P>()
        val visited = Array(n){
            Array(m){
                false
            }
        }
        //빙산이 둘로 나뉘어져 있는지 검사
        var isFirst = 0
        for(i in 0 until n){
            for(j in 0 until m) {
                if(arr[i][j]!=0 && !visited[i][j]){
                    if(isFirst >= 1){
                        print(result)
                        return
                    }
                    isFirst++
                    q.addLast(P(i,j))
                    visited[i][j] = true
                    while(!q.isEmpty()){
                        val p = q.removeFirst()
                        for(i in 0..3){
                            val ny = p.y + dy[i]
                            val nx = p.x + dx[i]
                            // 예외
                            if(nx<0 || nx>=m || ny<0 || ny>=n) continue
                            // 방문한 경우 처리 안함
                            if(visited[ny][nx]) continue
                            if(arr[ny][nx] != 0) {
                                q.addLast(P(ny, nx))
                                visited[ny][nx] = true
                            }
                        }
                    }
                }
            }
        }
        
        if(isFirst == 0){
            print(0)
            return
        }

        // 빙산 녹임
        result++
        for(i in 0 until n){
            for(j in 0 until m) {
                if(arr[i][j]!=0){
                    for(k in 0..3){
                        if(arr[i][j]==0) break
                        val ny = i + dy[k]
                        val nx = j + dx[k]
                        // 예외
                        if(nx<0 || nx>=m || ny<0 || ny>=n) continue
                        if(visited[ny][nx]) continue
                        arr[i][j]--
                    }
                }
            }
        }
    }
}
