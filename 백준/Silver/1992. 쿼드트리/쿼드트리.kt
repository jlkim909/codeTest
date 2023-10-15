package binarySearch

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var quadArr:Array<Array<Char>>
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    quadArr = Array(n){
        val t = br.readLine()
        Array(n){
            t[it]
        }
    }
    print(compressQuad(0,0,n))
}

private fun compressQuad(r:Int, c:Int, size:Int):String{
    var tempValue = quadArr[r][c]
    var str = ""
    for(i in r until r + size){
        for(j in c until c + size){
            if(tempValue != quadArr[i][j]){
                str += compressQuad(r, c, size/2)
                str += compressQuad(r , c + size/2, size/2)
                str += compressQuad(r + size/2, c, size/2)
                str += compressQuad(r  + size/2, c  + size/2, size/2)
                return "($str)"
            }
        }
    }
    if(str == ""){
        str+= tempValue
    }
    return "$str"
}