import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.StringTokenizer

fun main(){
    val q = Queue()
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(br.readLine().toInt()){
        val token = StringTokenizer(br.readLine())
        when(token.nextToken()){
            "push" -> {
                q.push(token.nextToken().toInt())
            }
            "pop" -> bw.write(q.pop().toString() + "\n")
            "size" -> bw.write(q.size().toString() + "\n")
            "empty" -> bw.write(q.empty().toString() + "\n")
            "front" -> bw.write(q.front().toString() + "\n")
            "back" -> bw.write(q.back().toString() + "\n")
        }
    }

    bw.flush()
    bw.close()
}

class Queue {
    val arr = LinkedList<Int>()

    fun push(num:Int){
        arr.add(num)
    }

    fun pop():Int{
        if(arr.isEmpty()){
            return -1
        }

        val front = arr[0]
        arr.removeAt(0)

        return front
    }

    fun size():Int{
        return arr.size
    }

    fun empty():Int{
        if(arr.isEmpty())
            return 1
        else return 0
    }

    fun front():Int{
        if(arr.isEmpty())
            return -1
        return arr[0]
    }

    fun back():Int{
        if(arr.isEmpty()) return -1
        return arr[arr.size-1]
    }
}