package DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main(){
    data class Building(val h:Int, var front:Long)
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val s = Stack<Int>()
    repeat(n){
        s.push(br.readLine().toInt())
    }
    val build = Stack<Building>()
    build.push(Building(s.pop(), 0))
    var result = 0L
    while(!s.isEmpty()){
        val h = s.pop()
        var front = 0L
        while(!build.isEmpty()){
            val b = build.peek()
            if(b.h == h){
                build.pop()
                front += b.front + 1
                break
            } else if(b.h < h){
                build.pop()
                front += b.front + 1
                result += b.front + 1
            } else{
                break
            }
        }
        build.push(Building(h,front))
    }
    print(result)
}