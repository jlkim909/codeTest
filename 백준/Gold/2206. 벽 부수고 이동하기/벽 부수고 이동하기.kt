import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t1 = StringTokenizer(br.readLine())
    val n = t1.nextToken().toInt()
    val m = t1.nextToken().toInt()

    val dy = arrayOf(-1,1,0,0)
    val dx = arrayOf(0,0,-1,1)
    val map = Array(n){
        Array(m){
            true
        }
    }

    val visited = Array(n){
        Array(m){
            arrayOf(0, 0)
        }
    }
    for(y in 0 until n){
        val t2 = br.readLine()
        for(x in 0 until m){
            if(t2[x] == '1') map[y][x] = false
        }
    }

    val q = ArrayDeque<P>()
    q.addLast(P(0,0))
    visited[0][0][0] = 1
    visited[0][0][1] = -1


    while(!q.isEmpty()){
        val p = q.removeFirst()
        //println("${p.y},${p.x}")
        if(p.y == n-1 && p.x == m-1){
            if(!p.isBreak) print(visited[p.y][p.x][0])
            else print(visited[p.y][p.x][1])
            return
        }
        for(i in 0..3){
            val ny = p.y + dy[i]
            val nx = p.x + dx[i]
            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue
            // 벽o 벽x (2), 깸o, 깸x(2), 방문o, 방문x(2)= 총 8가지의 경우의 수가 있음
            // 벽이 아니고 한 번도 안 깼을 때 방문 한 적 없음
            if(map[ny][nx] && !p.isBreak && visited[ny][nx][0] == 0){
                visited[ny][nx][0] = visited[p.y][p.x][0] + 1
                q.addLast(P(ny,nx,false))
            }
            // 벽이 아니고 한 번도 안 깼을 때 방문 한 적 있음(x)
            // 벽이 아니고 한 번 깼을 때 방문 한 적 없음
            if(map[ny][nx] && p.isBreak && visited[ny][nx][1] == 0){
                visited[ny][nx][1] = visited[p.y][p.x][1] + 1
                q.addLast(P(ny,nx,true))
            }
            // 벽이 아니고 한 번 깼을 때 방문 한 적 있음(x)
            // 벽이고 한 번도 안 깼을 때 방문 한 적 없음
            if(!map[ny][nx] && !p.isBreak && visited[ny][nx][1] == 0){
                visited[ny][nx][1] = visited[p.y][p.x][0] + 1
                q.addLast(P(ny,nx,true))
            }
            // 벽이고 한 번도 안 깼을 때 방문 한 적 있음(x)
            // 벽이고 한 번 깼을 때 방문 한 적 없음(x)
            // 벽이고 한 번 깼을 때 방문 한 적 있음(x)
        }
    }
    print(-1)
}

private data class P(val y:Int, val x:Int, val isBreak:Boolean = false)
