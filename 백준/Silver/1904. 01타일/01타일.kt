val d1 = Array<Int>(1000001){
    0
}

fun main(){
    val num = readln().toInt()
    d1[1] = 1
    d1[2] = 2
    for(n in 3..num){
        d1[n] = (d1[n-1] + d1[n-2])%15746
    }
    println(d1[num])
}