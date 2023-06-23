import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.StringTokenizer

fun main(){
    val q = Deque()
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(br.readLine().toInt()){
        val token = StringTokenizer(br.readLine())
        when(token.nextToken()){
            "push_front" -> {
                q.push_front(token.nextToken().toInt())
            }
            "push_back" -> {
                q.push_back(token.nextToken().toInt())
            }
            "pop_front" -> bw.write(q.pop_front().toString() + "\n")
            "pop_back" -> bw.write(q.pop_back().toString() + "\n")
            "size" -> bw.write(q.size().toString() + "\n")
            "empty" -> bw.write(q.empty().toString() + "\n")
            "front" -> bw.write(q.front().toString() + "\n")
            "back" -> bw.write(q.back().toString() + "\n")
        }
    }

    bw.flush()
    bw.close()
}

class Deque {
    // mutableList는 시간 초과
    private val arr = LinkedList<Int>()

    fun push_front(num:Int){
        arr.addFirst(num)
    }

    fun push_back(num:Int){
        arr.addLast(num)
    }

    fun pop_front():Int{
        if(arr.isEmpty()){
            return -1
        }

        val front = arr[0]
        arr.removeAt(0)

        return front
    }

    fun pop_back():Int{
        if(arr.isEmpty()){
            return -1
        }
        val back = arr[arr.size-1]
        arr.removeAt(arr.size-1)
        return back
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