import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    repeat(br.readLine().toInt()){
        val n = br.readLine().toInt()
        val t1 = StringTokenizer(br.readLine())
        val market = Array(n){
            t1.nextToken().toInt()
        }
        var mp = market[n-1]
        var result:Long = 0
        for(i in n-2 downTo 0){
            if(mp < market[i]){
                mp = market[i]
            }
            else if(mp > market[i]){
                result+=mp-market[i]
            }
        }
        println(result)
    }
}