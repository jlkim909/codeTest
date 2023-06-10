val a1 = Array(301){
    0
}

val r1 = Array(301){
    Array(2){0}
}

fun main(){
    val n = readln().toInt()
    repeat(n) {
        a1[it + 1] = readln().toInt()
    }
    println(maxOf(dp1(n,0),dp1(n,1)))
}


// r1[1] = 10
// r1[2] = dp1(1,0), dp1(0,1) + a1[2]
fun dp1(n:Int, cnt:Int):Int{
    if(n<0) return 0
    if(r1[n][cnt] > 0) return r1[n][cnt]
    r1[n][0] = maxOf(dp1(n-2, 0), dp1(n-2, 1)) + a1[n]
    r1[n][1] = dp1(n-1,0) + a1[n]
    return r1[n][cnt]
}