import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val t1 = StringTokenizer(br.readLine())
    val t2 = StringTokenizer(br.readLine())
    val A = MutableList(n){
        t1.nextToken().toInt()
    }

    val B = MutableList(n){
        t2.nextToken().toInt()
    }

    A.sort()
    B.sort()
    B.reverse()

    var sum = 0
    repeat(n){
        sum += A[it] * B[it]
    }
    
    print(sum)
}