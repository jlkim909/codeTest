package All

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private val dy = arrayOf(-1, 0, 1, 0)
private val dx = arrayOf(0, 1, 0, -1)
fun main(){
    data class P(val y:Int, val x:Int, val t:Int)
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val map = Array(r){
        val s = br.readLine()
        Array(c){j->
            s[j]
        }
    }

    map[r-1][0] = 'T'
    print(dfs(r,c,k,r-1,0,1,map))
}

private fun dfs(r:Int, c:Int, k:Int, y:Int, x:Int, t:Int, map:Array<Array<Char>>):Int{
    if(0 == y && c-1 == x && t==k){
        return 1
    }
    var sum = 0
    for(i in 0..3){
        val ny = y + dy[i]
        val nx = x + dx[i]
        if(ny in 0 until r && nx in 0 until c
            && map[ny][nx] != 'T'){
            map[ny][nx] = 'T'
            sum += dfs(r,c,k,ny,nx,t+1,map)
            map[ny][nx] = '.'
        }
    }
    return sum
}