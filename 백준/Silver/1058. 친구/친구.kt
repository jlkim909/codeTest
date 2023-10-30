package All

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val isFriend = Array(n){
        mutableListOf<Int>()
    }

    repeat(n){i ->
        val s = br.readLine()
        for(j in 0 until n){
            if(s[j] == 'Y') isFriend[i].add(j)
        }
    }

    val isVisisted = Array(n){
        Array(n){
            false
        }
    }

    var result = 0
    for(i in 0 until n){
        var cnt = 0
        isVisisted[i][i] = true
        for(j in isFriend[i]){
            if(!isVisisted[i][j]){
                isVisisted[i][j] = true
                cnt++
            }
            isFriend[j].forEach{
                if(!isVisisted[i][it]){
                    isVisisted[i][it] = true
                    cnt++
                }
            }
        }
        result = maxOf(result, cnt)
    }

    print(result)
}