import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Scanner
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var k = 0
    val scanner = Scanner(System.`in`)
    while(true) {
        k++
        val row = scanner.nextInt()
        if(row == 0) break
        val gr = Array(row) {
            Array(3){
                0
            }
        }
        val t = Array(row) {
            Array(3){
                0
            }
        }
        for(temp in gr){
            // val inp = StringTokenizer(br.readLine())
            repeat(3){
                temp[it] = scanner.nextInt()
            }
        }

        t[0][0] = 1000000000
        t[0][1] = gr[0][1]
        t[0][2] = gr[0][1] + gr[0][2]
        for(r in 1 until row){
            t[r][0] = minOf(t[r-1][0], t[r-1][1]) + gr[r][0]
            t[r][1] = minOf(t[r-1][0], t[r-1][1], t[r-1][2], t[r][0]) + gr[r][1]
            t[r][2] = minOf(t[r-1][1], t[r-1][2], t[r][1]) + gr[r][2]
        }

        println("${k}. ${t[row-1][1]}")
    }
}
