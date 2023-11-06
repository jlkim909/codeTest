package All

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import kotlin.math.floor

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val s = br.readLine()
    val arr = Array(n){
        br.readLine().toDouble()
    }
    val stack = Stack<Double>()
    for(c in s){
        if(c-'A' in 0..25){
            stack.add(arr[c-'A'])
            continue
        }
        var top = stack.pop()
        when(c){
            '*' -> {
                top *= stack.pop()
            }
            '/' -> {
                top = stack.pop() / top
            }
            '+' -> {
                top += stack.pop()
            }
            '-' -> {
                top = stack.pop() - top
            }
        }
        stack.add(top)
    }
    println(String.format("%.2f",floor(stack.peek()*100)/100))
}