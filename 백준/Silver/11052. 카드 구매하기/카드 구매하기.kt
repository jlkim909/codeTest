import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

val p1 = Array<Int>(1001){
    0
}

val p2 = Array<Int>(1001){
    0
}

// f[4] = min(f[1] + f[3], f[2] + f[2], p[4])
// O(1/2*n^2) n<=1000, 1000000
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = readln().toInt()
    val inp = StringTokenizer(br.readLine())
    repeat(n){
        p1[it+1] = inp.nextToken().toInt()
    }
    println(bp(n))

}

fun bp(n:Int):Int{
    if(p2[n] > 0) return p2[n]
    var temp = 0
    for(num in 1..n/2){
        var temp2 = bp(num)+bp(n-num)
        if(temp < temp2)
            temp = temp2
    }
    p2[n] = maxOf(temp,p1[n])
    return p2[n]
}