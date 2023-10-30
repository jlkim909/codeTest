package All

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    data class Robot(var y:Int, var x:Int, var dir:Int)
    data class Order(val rn:Int, val order:Char, val cnt:Int)
    val dy = arrayOf(-1, 0 , 1, 0)
    val dx = arrayOf(0, 1, 0, -1)
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val b = st.nextToken().toInt()
    val a = st.nextToken().toInt()
    st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val robot = Array(n){
        st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt()-1
        val y = a - st.nextToken().toInt()
        val dir = when(st.nextToken()[0]){
            'N' -> 0
            'E' -> 1
            'S' -> 2
            'W' -> 3
            else -> 0
        }
        Robot(y, x, dir)
    }

    val orderList = mutableListOf<Order>()
    repeat(m){
        st = StringTokenizer(br.readLine())
        val rn = st.nextToken().toInt()-1
        val order = st.nextToken()[0]
        val on = st.nextToken().toInt()
        orderList.add(Order(rn, order, on))
    }
    orderList.forEach{i ->
        val rn = i.rn
        val order = i.order
        var on = i.cnt
        when(order){
            'F' -> {
                var ny = robot[rn].y
                var nx = robot[rn].x
                repeat(on) {
                    ny += dy[robot[rn].dir]
                    nx += dx[robot[rn].dir]
                    if (ny >= a || ny < 0 || nx >= b || nx < 0) {
                        print("Robot ${rn + 1} crashes into the wall")
                        return
                    }
                    for (i in 0 until n) {
                        if (i == rn) continue
                        if (ny == robot[i].y && nx == robot[i].x){
                            print("Robot ${rn + 1} crashes into robot ${i + 1}")
                            return
                        }
                    }
                }
                robot[rn].y = ny
                robot[rn].x = nx
            }
            'L' -> {
                on%=4
                var cd = robot[rn].dir
                repeat(on){
                    cd--
                    if(cd < 0) cd = 3
                }
                robot[rn].dir = cd
            }
            'R' -> {
                on%=4
                var cd = robot[rn].dir
                repeat(on){
                    cd++
                    if(cd > 3) cd = 0
                }
                robot[rn].dir = cd
            }
        }
    }
    print("OK")
}