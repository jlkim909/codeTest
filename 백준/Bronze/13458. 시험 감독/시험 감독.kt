package All

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val roomArr = mutableListOf<Int>()
    var st = StringTokenizer(br.readLine())
    repeat(n){
        roomArr.add(st.nextToken().toInt())
    }
    st = StringTokenizer(br.readLine())
    val b = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    var result = 0L
    for(num in roomArr){
        var temp = num
        var sum = 1L
        temp-=b
        if(temp > 0){
            sum += temp/c
            if(temp%c != 0){
                sum++
            }
        }
        result+=sum
    }
    print(result)
}