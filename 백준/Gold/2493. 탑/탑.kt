import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = Stack<Array<Int>>()
    val n = br.readLine().toInt()
    val token = StringTokenizer(br.readLine())
    s.push(arrayOf(100000001,0))
    var k = 0
    while(token.hasMoreTokens()){
        val h = token.nextToken().toInt()
        while(s.peek()[0] < h){
            s.pop()
        }
        print("${s.peek()[1]} ")
        s.push(arrayOf(h,++k))
    }
}