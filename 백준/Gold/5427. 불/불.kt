import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// idea 1
// 1. bfs로 건물에서 빈 공간에 불이 도달한 시간을 체크한다
// 2. 불이 도달한 시간이 있는 건물에서 dfs를 사용해 상근이가 건물을 탈출할 경로를 찾는다.
// 3. 상근이가 이동한 시간과 빈 공간에 불이 도달한 시간을 비교하여 이동 여부를 결정한다.

// idea 2
// 1. bfs로 1회 마다 빈 공간에 불 이동, 불 이동 후에 상근 이동

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    repeat(br.readLine().toInt()){
        val t1 = StringTokenizer(br.readLine())
        val w = t1.nextToken().toInt()
        val h = t1.nextToken().toInt()
        val map = Array(h){
            Array(w){
                -2
            }
        }
        val q = ArrayDeque<Triple<Char,Int,Int>>()
        lateinit var sp:Pair<Int,Int>
        // 벽, 불 : 0
        for(th in 0 until h){
            val t2 = br.readLine()
            for(tw in 0 until w){
                when(t2[tw]){
                    '#' -> {
                        map[th][tw] = -1
                    }
                    '*' -> {
                        map[th][tw] = -1
                        q.add(Triple('*',th,tw))
                    }
                    '@' -> {
                        map[th][tw] = 0
                        sp = Pair(th,tw)
                    }
                }
            }
        }
        q.add(Triple('@',sp.first,sp.second))
        // 불이 퍼지는 시간을 맵에 기록
        var result = -1
        while(!q.isEmpty()){
            val p = q.removeFirst()
            val ts = p.first
            val th = p.second
            val tw = p.third
            val time = map[th][tw]
            if(ts == '@') {
                if (th == 0 || th == h - 1 || tw == 0 || tw == w - 1) {
                    result = time
                    break
                }
            }
            // 아래
            if (th > 0 && map[th - 1][tw] == -2) {
                map[th - 1][tw] = time + 1
                q.add(Triple(ts,th - 1, tw))
            }
            // 위
            if (th + 1 < h && map[th + 1][tw] == -2) {
                map[th + 1][tw] = time + 1
                q.add(Triple(ts,th + 1, tw))
            }
            // 좌
            if (tw > 0 && map[th][tw - 1] == -2) {
                map[th][tw - 1] = time + 1
                q.add(Triple(ts,th, tw - 1))
            }
            // 우
            if (tw + 1 < w && map[th][tw + 1] == -2) {
                map[th][tw + 1] = time + 1
                q.add(Triple(ts,th, tw + 1))
            }
        }

        if(result == -1){
            println("IMPOSSIBLE")
        } else {
            println(result + 1)
        }
    }
}

