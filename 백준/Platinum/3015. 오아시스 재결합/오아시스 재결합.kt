import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

// 3 2 2 1 2
// (3,1), 0
// (3,1), (2,1), 1
// (3,1), (2,2), 3
// (3,1), (2,2), (1,1), 4
// (3,1), 8

// 9 6 4 8 8 2 7 10 5 5
// (9,1), 0
// (9,1), (6, 1), 1
// (9,1), (6, 1), (4,1), 2
// (9,1), (8,1), 5
// (9,1), (8,2), 7
// (9,1), (8,2), (2, 1), 8
// (9,1), (8,2), (7,1), 10
// 15

// 7 7 7 7
// (7,1), 0
// (7,2), 1
// (7,3), 3
// (7,4), 6
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = Stack<Pair<Int,Int>>()
    var result:Long = 0
    repeat(br.readLine().toInt()){
        val next = br.readLine().toInt()
        var cnt = 1
        while(!s.isEmpty()){
            if(next < s.peek().first){
                result++
                break
            }
            if(next == s.peek().first){
                cnt = s.peek().second + 1
            }
            result+=s.pop().second
        }
        s.push(Pair(next, cnt))
    }
    print(result)
}