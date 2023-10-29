package All

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val h = st.nextToken().toInt()
    val w = st.nextToken().toInt()
    val h2 = st.nextToken().toInt()
    val w2 = st.nextToken().toInt()
    val b = Array(h+h2){
        st = StringTokenizer(br.readLine())
        Array(w+w2){
            st.nextToken().toInt()
        }
    }

    val a = Array(h){
        Array(w){
            0
        }
    }
    for(i in 0 until h2){
        for(j in 0 until w) {
            a[i][j] = b[i][j]
        }
    }

    for(i in h-h2 until h){
        for(j in 0 until w) {
            a[i][j] = b[i+h2][j+w2]
        }
    }

    for(i in 0 until w2){
        for(j in 0 until h){
            a[j][i] = b[j][i]
        }
    }

    for(i in w-w2 until w){
        for(j in 0 until h){
            a[j][i] = b[j+h2][i+w2]
        }
    }

    for(i in h2 until h-h2){
        for(j in w2 until w-w2){
            a[i][j] = b[i][j] - a[i-h2][j-w2]
        }
    }

    for(i in a){
        for(j in i){
            print("$j ")
        }
        println()
    }
}