import java.io.BufferedReader
import java.io.InputStreamReader
private var num = 0
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    repeat(br.readLine().toInt()){
        num = br.readLine().toInt()
        println(plus123(0))
    }
}

fun plus123(cn:Int):Int{
    if(num == cn){
        return 1
    }
    if(cn > num){
        return 0
    }
    var result = 0
    for(i in 1..3){
        result+=plus123(cn+i)
    }
    return result
}