package DP

import java.io.BufferedReader
import java.io.InputStreamReader

val d = Array(5001){
    0
}
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val code = br.readLine()
    if(code[0] == '0'){
        print(0)
        return
    }
    print(codeFun(code, code.length))
}

private fun codeFun(code:String, n:Int):Int{
    if(n <= 1){
        return 1
    }
    if(d[n] != 0){
        return d[n]
    }

    val sliceCode = code.slice(n-2 until n)
    if(sliceCode[1] == '0'){
        if(sliceCode.toInt() > 20){
            d[n] = 0
        }else if(sliceCode.toInt() == 0) {
            d[n] = 0
        }else{
            d[n] = codeFun(code, n - 2)
        }
    }else if(sliceCode[0]=='0' || sliceCode.toInt() > 26){
        d[n] = codeFun(code, n-1)
    }else{
        d[n] = (codeFun(code, n-1) + codeFun(code, n-2))%1000000
    }
    return d[n]
}