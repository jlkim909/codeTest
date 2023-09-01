package BFSDFS

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private val dx = arrayOf(0, 0, -1, 1)
private val dy = arrayOf(-1, 1, 0, 0)
private var m = 0
private var n = 0
private lateinit var map: Array<Array<Int>>
private val d = Array(501){
    Array(501){
        -1
    }
}
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t1 = StringTokenizer(br.readLine())
    m = t1.nextToken().toInt()
    n = t1.nextToken().toInt()
    map = Array(m){
        val t2 = StringTokenizer(br.readLine())
        Array(n){
            t2.nextToken().toInt()
        }
    }

    // bfs -> 메모리 초과 : 지수개의 변수를 queue에 넣을 수 있음
    println(dfs(0,0))
}

private fun dfs(y:Int, x:Int):Int{
    if( y == m - 1 && x == n - 1){
        return 1
    }
    if(d[y][x] != -1){
        return d[y][x]
    }
    var sum = 0
    for(i in 0..3){
        val ny = y + dy[i]
        val nx = x + dx[i]
        if(ny >= 0 && nx >=0 && ny <= m-1 && nx <= n-1){
            if(map[y][x] > map[ny][nx]){
                sum += dfs(ny, nx)
            }
        }
    }

    d[y][x] = sum
    return d[y][x]
}