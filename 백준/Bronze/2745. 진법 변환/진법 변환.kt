import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var inp = StringTokenizer(br.readLine())
    var n = inp.nextToken()
    var b = inp.nextToken().toDouble()
    var sum = 0
    for(i in 0 until n.length){
        if(n[i].code-48 < 10){
            sum+=(n[i].code-48)*Math.pow(b,(n.length-i-1).toDouble()).toInt()
        }else{
            sum+=(n[i].code-55)*Math.pow(b,(n.length-i-1).toDouble()).toInt()
        }
    }

    println(sum)
    br.close()
}