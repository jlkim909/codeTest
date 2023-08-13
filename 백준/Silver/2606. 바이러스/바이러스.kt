package graph

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

val rank = Array(101){
    0
}

val parent = Array(101){
    0
}
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    for(i in 1..n){
        parent[i] = i
    }
    for(i in 0 until m){
        val t2 = StringTokenizer(br.readLine())
        val x = t2.nextToken().toInt()
        val y = t2.nextToken().toInt()
        union(x,y)
    }
    var result = 0
    for(i in 2..n){
        if(find(i) == find(1)){
            result++
        }
    }

    print(result)
}

fun find(x:Int) : Int{
    if(parent[x] == x){
        return x
    }else{
        parent[x] = find(parent[x])
        return parent[x]
    }
}
fun union(x:Int, y:Int){
    var nx = find(x)
    //println(nx)
    var ny = find(y)
    //println(ny)
    if(nx == ny) return
    if(rank[nx] < rank[ny]) {
        var temp = nx
        nx = ny
        ny = temp
    }
    parent[ny] = nx
    if(rank[nx] == rank[ny])
        rank[nx] = rank[ny]+1
    return
}