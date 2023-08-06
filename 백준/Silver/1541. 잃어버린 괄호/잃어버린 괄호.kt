import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val formula = br.readLine()
    var result = 0
    var t1 = 0
    var numList = mutableListOf<String>()
    for(c in formula){
        if(c.isDigit()){
            t1 = t1*10 + c.digitToInt()
        }
        else{
            numList.add(t1.toString())
            if(c == '-')
            numList.add(c.toString())
            t1 = 0
        }
    }
    numList.add(t1.toString())

    result += numList.removeFirst().toInt()
    var m = false
    for(tt in numList){
        if(tt == "-"){
            m = true
        }else{
            if(m){
                result -= tt.toInt()
            }else
                result += tt.toInt()
        }
    }
    println(result)
}