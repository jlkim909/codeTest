package binarySearch

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val map = Array(3000){
    Array(3000){
        0
    }
}

private val cnt = Array(3){0}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n){ i ->
        var t1 = StringTokenizer(br.readLine())
        var k = 0
        while(t1.hasMoreTokens()){
            map[i][k++] = t1.nextToken().toInt()
        }
    }

    paper(0,0,n)
    for(result in cnt){
        println(result)
    }
}

fun paper(r: Int, c: Int, n: Int) {
    if (n < 1) {
        return
    }
    val value: Int = map[r][c]
    for (i in r until r + n) {
        for (j in c until c + n) {
            if (map[i][j] !== value) {
                for (q in 0..2) {
                    for (p in 0..2) {
                        paper(r + q * (n / 3), c + p * (n / 3), n / 3)
                    }
                }
                return
            }
        }
    }
    cnt[value + 1]++
    return
}