import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for(i in 1 until n){
        var num = i
        var temp = num
        while (temp > 0) {
            num += temp % 10
            temp /= 10
        }
        if(num == n){
            print(i)
            return
        }
    }
    print(0)
    return
}