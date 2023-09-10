package greedy

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    var pre = '1'
    var result0 = 0
    var result1 = 0
    for(c in s){
        if(c == '0'){
            if(pre == '1'){
                result0++
            }
        }
        pre = c
    }
    pre = '0'
    for(c in s){
        if(c == '1'){
            if(pre == '0'){
                result1++
            }
        }
        pre = c
    }
    print(minOf(result0, result1))
}
