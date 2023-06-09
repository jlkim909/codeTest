val d = Array(1000010){
    0
}

val d2 = Array(10000010){
    0
}
fun main(){
    val n = readln().toInt()
    var answer = 0
    if(n>=0){
        answer = fibo(n)
    } else{
        answer = minusFibo(-n)
    }

    if(answer > 0){
        println(1)
        println(answer)
    }else if(answer == 0){
        println(0)
        println(0)
    }else{
        println(-1)
        if(answer > 0) println(answer) else println(-answer)
    }
}
fun fibo(n:Int):Int{
    d[0] = 0
    d[1] = 1
    for(num in 2..n){
        d[num] = (d[num-1] + d[num-2])%1000000000
    }
    return d[n]
}

fun minusFibo(n:Int):Int{
    d2[0] = 0
    d2[1] = 1
    for(num in 2..n){
        d2[num] = (d2[num-2] - d2[num-1])%1000000000
    }
    return d2[n]
}