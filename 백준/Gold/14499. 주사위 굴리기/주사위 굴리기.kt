package All

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private lateinit var dice:Array<Array<Int>>
private lateinit var map:Array<Array<Int>>
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    dice = Array(4){
        Array(3){
            0
        }
    }
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    var sy = st.nextToken().toInt()
    var sx = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    map = Array(n){
        Array(m){
            0
        }
    }
    repeat(n){i->
        st = StringTokenizer(br.readLine())
        repeat(m){j->
            map[i][j] = st.nextToken().toInt()
        }
    }
    st = StringTokenizer(br.readLine())
    repeat(k){
        var check = false
        when(st.nextToken().toInt()){
            1 -> {
                if(sx+1 < m) {
                    ea()
                    sx += 1
                    check = true
                }
            }
            2 -> {
                if(sx-1 >= 0) {
                    we()
                    sx -= 1
                    check = true
                }
            }
            3 -> {
                if(sy-1 >= 0) {
                    no()
                    sy -= 1
                    check = true
                }
            }
            4 -> {
                if(sy+1 < n) {
                    so()
                    sy += 1
                    check = true
                }
            }
        }
        if(check){
            println(dice[1][1])
            if(map[sy][sx] == 0){
                map[sy][sx] = dice[3][1]
            }else{
                dice[3][1] = map[sy][sx]
                map[sy][sx] = 0
            }
        }
    }

}

private fun no(){
    val temp = dice[0][1]
    for(i in 0..2){
        dice[i][1] = dice[i+1][1]
    }
    dice[3][1] = temp
}

private fun so(){
    val temp = dice[3][1]
    for(i in 0..2){
        dice[3-i][1] = dice[2-i][1]
    }
    dice[0][1] = temp
}

private fun ea(){
    val temp = dice[1][2]
    dice[1][2] = dice[1][1]
    dice[1][1] = dice[1][0]
    dice[1][0] = dice[3][1]
    dice[3][1] = temp
}

private fun we(){
    val temp = dice[1][0]
    dice[1][0] = dice[1][1]
    dice[1][1] = dice[1][2]
    dice[1][2] = dice[3][1]
    dice[3][1] = temp
}