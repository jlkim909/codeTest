package all

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val model = readLine().replace(" ", "")
    var reverseModel = ""
    model.reversed().forEach{
        if(it.isDigit()){
            reverseModel += when(it){
                '1' -> '3'
                '2' -> '4'
                '3' -> '1'
                '4' -> '2'
                else -> ' '
            }
        }
    }

    val modelList = mutableListOf<String>()
    var temp = model
    for(i in model.indices){
        modelList.add(temp)
        val first = temp.first()
        temp = temp.drop(1) + first
    }

    temp = reverseModel
    for(i in reverseModel.indices){
        modelList.add(temp)
        val first = temp.first()
        temp = temp.drop(1) + first
    }

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val m = readLine().toInt()
    var result = 0
    repeat(m){
        val l = readLine()
        if(modelList.contains(l.replace(" ", ""))){
            bw.write(l + "\n")
            result++
        }
    }

    println(result)
    bw.flush()
    bw.close()
}