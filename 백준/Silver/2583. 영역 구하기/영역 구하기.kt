import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = StringTokenizer(br.readLine())
    val m = t.nextToken().toInt()
    val n = t.nextToken().toInt()
    val k = t.nextToken().toInt()
    val d = Array(101){
        Array(101){false}
    }
    // 보드에 사각형 입력
    repeat(k){
        val t2 = StringTokenizer(br.readLine())
        val x1 = t2.nextToken().toInt()
        val y1 = t2.nextToken().toInt()
        val x2 = t2.nextToken().toInt()
        val y2 = t2.nextToken().toInt()
        for(py in y1 until y2){
            for(px in x1 until x2){
                d[py][px] = true
            }
        }
    }

    val result = mutableListOf<Int>()
    for(py in 0 until m){
        for(px in 0 until n){
            if(d[py][px]) continue
            val q = ArrayDeque<Pair<Int,Int>>()
            var size = 1
            d[py][px] = true
            q.add(Pair(py,px))

            while(!q.isEmpty()){
                val now = q.removeFirst()
                val ny = now.first
                val nx = now.second
                // 왼쪽 이동
                if(nx-1 >= 0 && !d[ny][nx-1]){
                    d[ny][nx-1]=true
                    q.add(Pair(ny,nx-1))
                    size++
                }
                // 오른쪽 이동
                if(nx+1 < n && !d[ny][nx+1]){
                    d[ny][nx+1]=true
                    q.add(Pair(ny,nx+1))
                    size++
                }
                // 위쪽 이동
                if(ny+1 < m && !d[ny+1][nx]){
                    d[ny+1][nx]=true
                    q.add(Pair(ny+1,nx))
                    size++
                }
                // 아래쪽 이동
                if(ny-1 >= 0 && !d[ny-1][nx]){
                    d[ny-1][nx]=true
                    q.add(Pair(ny-1,nx))
                    size++
                }
            }
            result.add(size)
        }
    }

    println(result.size)
    result.sort()
    for(s in result){
        print("$s ")
    }
}