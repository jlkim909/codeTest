// 123 4 56 7 89
// 3 * 2 * 2 = 12
// 1234 5 678 9 101112
// 1234, 1243, 1324, 2134, 2143
// 12 =1
// 1 23 = m[2] + m[1]*2 = 3
// 1234 = m[4] = m[3] + m[2] = 5
// 12345 = m[4] + m[3] = 8
// 1고정 2345
// 2345, 2354, 3245, 3254, 2435
// 21고정 345
// 345, 354, 435
// m[n] = m[n-1] + m[n-2]

val dd = Array(41){
    0
}
fun main(){
    dd[0]=1
    dd[1]=1
    dd[2]=2
    for(n in 3..40){
        dd[n] = dd[n-1] + dd[n-2]
    }
    val n = readln().toInt()
    val m = readln().toInt()
    var result = 1
    var temp = 0
    repeat(m){
        val temp2 = readln().toInt()
        result *= dd[temp2-temp-1]
        temp = temp2
    }
    result *= dd[n-temp]
    println(result)
}