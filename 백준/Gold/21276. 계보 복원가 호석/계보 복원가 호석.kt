package topologicalSorting

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var t1 = StringTokenizer(br.readLine())
    val g = mutableMapOf<String,MutableList<String>>()
    val result = mutableMapOf<String,MutableList<String>>()
    val nameArr = Array(n){
        t1.nextToken()
    }
    val ind = mutableMapOf<String,Int>()
    for(name in nameArr){
        g[name] = mutableListOf<String>()
        result[name] = mutableListOf<String>()
        ind[name] = 0
    }
    nameArr.sort()
    val m = br.readLine().toInt()
    repeat(m){
        t1 = StringTokenizer(br.readLine())
        val x = t1.nextToken()
        val y = t1.nextToken()
        g[x]?.add(y)
        ind[y] = ind[y]!! + 1
    }

    val resultFirst = mutableListOf<String>()
    for(name in nameArr){
        if(g[name]?.size == 0){
            resultFirst.add(name)
        }
    }
    resultFirst.sort()
    println(resultFirst.size)
    resultFirst.forEach{
        print("$it ")
    }
    println()

    val q = ArrayDeque<String>()
    for(name in nameArr){
        if(ind[name] == 0){
            q.add(name)
        }
    }

    while(!q.isEmpty()){
        val name = q.removeFirst()
        for(parent in g[name]!!){
            ind[parent] = ind[parent]!! - 1
            result[parent]?.add(name)
            for(k in result[name]!!){
                result[parent]?.remove(k)
            }
            if(ind[parent] == 0){
                q.add(parent)
            }
        }
    }

    for(name in nameArr){
        result[name]?.sort()
        print("$name ${result[name]?.size} ")
        for(child in result[name]!!){
            print("$child ")
        }
        println()
    }
}