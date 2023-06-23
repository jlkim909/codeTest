import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// 1 2 3 4 5 6 7 8 9 10
// 2 3 4 5 6 7 8 9 10 1 / 1
// 3 4 5 6 7 8 9 10 1 / 1
// 3 4 5 6 9 7 8 10 1 / 1
// 9 10 1 3 4 5 6 7 8 / 4
// 10 1 3 4 5 6 7 8 / 4
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val deq = ArrayDeque<Int>()
    val token = StringTokenizer(br.readLine())
    var n = token.nextToken().toInt()
    val m = token.nextToken().toInt()
    repeat(n){
        deq.add(it+1)
    }
    val t = StringTokenizer(br.readLine())
    var result = 0
    while(t.hasMoreTokens()){
        val num = t.nextToken().toInt()
        val size = deq.size
        val position = deq.indexOf(num)
        val isLeft = position <= size-position-1
        if(isLeft) {
            rotateLeft(position, deq)
            result+=position
        }
        else {
            rotateRight(size - position, deq)
            result+=size-position
        }
        deq.removeFirst()
    }
    print(result)
}

private fun rotateLeft(time:Int, d:ArrayDeque<Int>){
    repeat(time) {
        var temp = d.removeFirst()
        d.add(temp)
    }
}

private fun rotateRight(time:Int, d:ArrayDeque<Int>){
    repeat(time) {
        var temp = d.removeLast()
        d.addFirst(temp)
    }
}