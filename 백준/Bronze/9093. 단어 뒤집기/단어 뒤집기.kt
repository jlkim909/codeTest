import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(br.readLine().toInt()){
        val token = StringTokenizer(br.readLine())
        for(word in token){
            bw.write(word.toString().reversed() + " ")
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
//    val tc = readln().toInt()
//    var result = mutableListOf<String>()
//    repeat(tc){
//        val s = readln()
//        val sk = Stack<Char>()
//        var re = ""
//        for(c in s){
//            if(c == ' '){
//                while(!sk.empty()){
//                    re += sk.pop()
//                }
//                re +=' '
//                continue
//            }
//            sk.push(c)
//        }
//        while(!sk.empty()){
//            re += sk.pop()
//        }
//        result.add(re)
//    }
//
//    repeat(result.size){
//        println(result[it])
//    }
}