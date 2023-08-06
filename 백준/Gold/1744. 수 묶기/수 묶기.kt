import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val minusList = mutableListOf<Int>()
    val plusList = mutableListOf<Int>()
    repeat(n){
        val t = br.readLine().toInt()
        if(t>0){
            plusList.add(t)
        }else{
            minusList.add(t)
        }
    }
    var result = 0
    var t = 0
    minusList.sort()
    for(n in minusList){
        if(t==0){
            t = n
        }else{
            t *= n
            result += t
            t = 0
        }
    }
    result += t

    plusList.sort()
    plusList.reverse()

    t = 0
    for(n in plusList){
        if(n <= 1){
            result+=n
            continue
        }
        if(t==0){
            t = n
        }else{
            t *= n
            result += t
            t = 0
        }
    }
    result += t
    print(result)
}