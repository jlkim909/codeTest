import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val k = br.readLine().toInt()
    val lope = Array(k){
        br.readLine().toInt()
    }

    lope.sort()

    var result = 0
    repeat(k){
        val weight = lope[it] * (k-it)
        if(result < weight){
            result = weight
        }
    }

    print(result)
}