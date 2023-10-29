package All

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    data class Truck(var p:Int, var w:Int)
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val w = st.nextToken().toInt()
    val l = st.nextToken().toInt()
    val truck = Array(n){
        Truck(0,0)
    }
    st = StringTokenizer(br.readLine())
    repeat(n){
        truck[it].w = st.nextToken().toInt()
    }

    var second = 0
    val dq = ArrayDeque<Truck>()
    dq.add(Truck(w,0))
    var truckNum = 0
    var totalWeight = 0

    while(!dq.isEmpty() || truckNum < n){
        for(truck in dq){
            truck.p++
        }

        if(dq.first().p >= w){
            totalWeight -= dq.removeFirst().w
        }


        if(truckNum < n) {
            val nt = truck[truckNum]
            if (totalWeight + nt.w <= l) {
                truckNum++
                totalWeight += nt.w
                dq.add(nt)
            }
        }
        second++
    }
    print(second)
}