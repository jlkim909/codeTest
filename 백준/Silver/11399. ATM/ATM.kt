import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()
    val temp = StringTokenizer(br.readLine())
    val time = mutableListOf<Int>()
    repeat(n.toInt()){
        time.add(temp.nextToken().toInt())
    }
    time.sort()
    var r1 = 0
    var result = 0
    for(t in time){
        r1 += t
        result += r1
    }
    print(result)
}