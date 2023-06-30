import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    while(true){
        val t1 = StringTokenizer(br.readLine())
        val l = t1.nextToken().toInt()
        val r = t1.nextToken().toInt()
        val c = t1.nextToken().toInt()
        if(l == 0 && r == 0 && c == 0) break

        val map = Array(l){
            Array(r){
                Array(c){
                    0
                }
            }
        }

        val q = ArrayDeque<Triple<Int,Int,Int>>()
        lateinit var e:Triple<Int,Int,Int>
        for(tl in 0 until l){
            for(tr in 0 until r){
                val t2 = br.readLine()
                for(tc in 0 until c){
                    when(t2[tc]){
                        'S' -> q.add(Triple(tl, tr, tc))
                        '.' -> map[tl][tr][tc] = -1
                        'E' -> {
                            map[tl][tr][tc] = -1
                            e = Triple(tl,tr,tc)
                        }
                    }
                }
            }
            br.readLine()
        }

        var isEscape = false
        while(!q.isEmpty()){
            val p = q.removeFirst()
            val tl = p.first
            val tr = p.second
            val tc = p.third
            val minute = map[tl][tr][tc]
            if(p == e){
                println("Escaped in $minute minute(s).")
                isEscape = true
                break
            }

            if(tl > 0 && map[tl-1][tr][tc] == -1){
                map[tl-1][tr][tc] = minute + 1
                q.add(Triple(tl-1, tr, tc))
            }
            if(tl + 1 < l && map[tl+1][tr][tc] == -1){
                map[tl+1][tr][tc] = minute + 1
                q.add(Triple(tl+1, tr, tc))
            }
            if(tr > 0 && map[tl][tr-1][tc] == -1){
                map[tl][tr-1][tc] = minute + 1
                q.add(Triple(tl, tr-1, tc))
            }
            if(tr + 1< r && map[tl][tr+1][tc] == -1){
                map[tl][tr+1][tc] = minute + 1
                q.add(Triple(tl, tr+1, tc))
            }
            if(tc > 0 && map[tl][tr][tc-1] == -1){
                map[tl][tr][tc-1] = minute + 1
                q.add(Triple(tl, tr, tc-1))
            }
            if(tc + 1 < c && map[tl][tr][tc+1] == -1){
                map[tl][tr][tc+1] = minute + 1
                q.add(Triple(tl, tr, tc+1))
            }
        }

        if(!isEscape){
            println("Trapped!")
        }
    }
}