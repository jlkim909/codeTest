package All

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var st = StringTokenizer(br.readLine())
    val sw = Array(n + 1){
        false
    }
    for(i in 1..n){
        sw[i] = st.nextToken().toInt() == 1
    }
    val m = br.readLine().toInt()
    repeat(m){
        st = StringTokenizer(br.readLine())
        val isMan = st.nextToken().toInt() == 1
        val switch = st.nextToken().toInt()
        if(isMan){
            for(i in 1..n){
                if(i != 0 && i % switch == 0){
                    sw[i] = !sw[i]
                }
            }
        }else{
            var front = switch - 1
            var back = switch + 1
            sw[switch] = !sw[switch]
            while(true){
                if(front <= 0){
                    break
                }
                if(back > n){
                    break
                }
                if(sw[front] == sw[back]){
                    sw[front] = !sw[front]
                    sw[back] = !sw[back]
                    front--
                    back++
                }else{
                    break
                }
            }
        }
    }
    for(i in 1..n){
        if(sw[i]){
            print("1 ")
        } else {
            print("0 ")
        }
        if(i%20 == 0){
            println()
        }
    }
}