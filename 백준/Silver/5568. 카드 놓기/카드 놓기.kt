import java.io.BufferedReader
import java.io.InputStreamReader

private var n = 0
val card = mutableListOf<String>()
val result = mutableListOf<String>()
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    val k = br.readLine().toInt()
    repeat(n){
        card.add(br.readLine())
    }
    makeCardNum(k, "", Array(n){false})
    println(result.size)
}

fun makeCardNum(k:Int, cn:String, visited:Array<Boolean>){
    if(k==0){
        if(result.contains(cn)) return
        result.add(cn)
        return
    }
    for(i in 0 until n){
        if(!visited[i]) {
            visited[i] = true
            makeCardNum(k - 1, cn+card[i], visited)
            visited[i] = false
        }
    }
}