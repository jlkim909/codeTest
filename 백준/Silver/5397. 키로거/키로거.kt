import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.LinkedList
import java.util.Stack

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(br.readLine().toInt()){
        val str = br.readLine()
        val linkedList = LinkedList<Char>()
        val listIterator = linkedList.listIterator()
        for(c in str){
            when(c) {
                '<' -> {
                    if(listIterator.hasPrevious())
                        listIterator.previous()
                }
                '>' -> {
                    if(listIterator.hasNext())
                        listIterator.next()
                }
                '-' -> {
                    if(listIterator.hasPrevious()) {
                        listIterator.previous()
                        listIterator.remove()
                    }
                }
                else -> {
                    listIterator.add(c)
                }
            }
        }
        val result = StringBuilder()
        for(c in linkedList){
            result.append(c)
        }
        bw.write(result.toString() + "\n")
    }
    bw.flush()
    bw.close()
}