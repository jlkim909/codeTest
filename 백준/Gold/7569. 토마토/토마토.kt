import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Queue
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t1 = StringTokenizer(br.readLine())
    val m = t1.nextToken().toInt()
    val n = t1.nextToken().toInt()
    val h = t1.nextToken().toInt()

    val tomatoBox = Array(h){
        Array(n){
            Array(m){
                -1
            }
        }
    }
    val q = ArrayDeque<Triple<Int,Int,Int>>()

    for(th in 0 until h){
        for(tn in 0 until n){
            val t2 = StringTokenizer(br.readLine())
            for(tm in 0 until m){
                val state = t2.nextToken().toInt()
                if(state == 1){
                    q.add(Triple(th,tn,tm))
                    tomatoBox[th][tn][tm] = 0
                } else if(state == -1){
                    tomatoBox[th][tn][tm] = 0
                }
            }
        }
    }

    while(!q.isEmpty()){
        val p = q.removeFirst()
        val th = p.first
        val tn = p.second
        val tm = p.third
        val day = tomatoBox[th][tn][tm]
        // 앞
        if(th > 0 && tomatoBox[th-1][tn][tm] == -1){
            tomatoBox[th-1][tn][tm] = day + 1
            q.add(Triple(th - 1, tn, tm))
        }
        // 뒤
        if(th + 1 < h && tomatoBox[th+1][tn][tm] == -1){
            tomatoBox[th+1][tn][tm] = day + 1
            q.add(Triple(th + 1, tn, tm))
        }
        // 위
        if(tn + 1 < n && tomatoBox[th][tn+1][tm] == -1){
            tomatoBox[th][tn+1][tm] = day + 1
            q.add(Triple(th, tn + 1, tm))
        }
        // 아래
        if(tn > 0 && tomatoBox[th][tn-1][tm] == -1){
            tomatoBox[th][tn-1][tm] = day + 1
            q.add(Triple(th, tn - 1, tm))
        }
        // 오
        if(tm + 1 < m && tomatoBox[th][tn][tm+1] == -1){
            tomatoBox[th][tn][tm+1] = day + 1
            q.add(Triple(th, tn, tm + 1))
        }
        // 왼
        if(tm > 0 && tomatoBox[th][tn][tm-1] == -1){
            tomatoBox[th][tn][tm-1] = day + 1
            q.add(Triple(th, tn, tm - 1))
        }
    }

    var result = 0
    for(th in 0 until h){
        for(tn in 0 until n){
            for(tm in 0 until m){
                if(tomatoBox[th][tn][tm] == -1){
                    print(-1)
                    return
                }
                result = maxOf(result, tomatoBox[th][tn][tm])
            }
        }
    }
    print(result)
}