import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

private var n = 0
private var p2 = 0
private val d = Array(101){
    LinkedList<Int>()
}
private val visited = Array(101){
    false
}
fun main(){
    // d[2] = 1
    // d[3] = 1
    // d[7] = 2

    // 해결방법 : 부모와 자식을 연결시킨 후 연결이 끊어질때까지 촌수를 센다.
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    val t = StringTokenizer(br.readLine())
    val p1 = t.nextToken().toInt()
    p2 = t.nextToken().toInt()
    repeat(br.readLine().toInt()){
        val t2 = StringTokenizer(br.readLine())
        val r1 = t2.nextToken().toInt()
        val r2 = t2.nextToken().toInt()
        // 부모-자식 연결
        d[r1].add(r2)
        d[r2].add(r1)
    }
    print(dfs(p1, 0))
}

private fun dfs(v:Int, t:Int):Int{
    if(v == p2) return t
    visited[v] = true
    for(next in d[v]){
        if(!visited[next]){
            val result = dfs(next, t+1)
            if(result != -1){
                return result
            }
        }
    }
    return -1
}