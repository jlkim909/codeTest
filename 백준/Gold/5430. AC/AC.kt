package DataStructure

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    repeat(t){
        val p = br.readLine()
        val n = br.readLine().toInt()
        val s = br.readLine()
        val arr = ArrayDeque<Int>()
        var num = 0
        s.forEach {
            if (it != '[' && it != ']' && it != ',') {
                num *= 10
                num += it.digitToInt()
            }

            if (it == ',') {
                arr.add(num)
                num = 0
            }
        }
        if (num != 0) arr.add(num)
        var check = true
        var isFront = true

        for (c in p) {
            when (c) {
                'R' -> isFront = !isFront
                'D' -> {
                    if (arr.isEmpty()) {
                        check = false
                    } else if (isFront) {
                        arr.removeFirst()
                    } else {
                        arr.removeLast()
                    }
                }
            }
        }

        if (!isFront) arr.reverse()
        if (check) {
            bw.write("[")
            for (i in 0 until arr.size - 1) {
                bw.write("${arr[i]},")
            }
            if(!arr.isEmpty()) {
                bw.write("${arr.last()}]\n")
            }else bw.write("]\n")
        } else bw.write("error\n")
    }
    bw.flush()
    bw.close()
}