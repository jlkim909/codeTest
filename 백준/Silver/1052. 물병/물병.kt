package Greedy

fun main() = with(System.`in`.bufferedReader()){
    val (n, k) = readLine().split(" ").map{it.toInt()}
    val binaryN = Integer.toBinaryString(n)
    if(binaryN.count{it == '1'} <= k){
        print(0)
        return
    }
    var temp = k
    for((i,c) in binaryN.withIndex()){
        if(c == '1'){
            temp--
            if(temp == 0) {
                val s1 = binaryN.substring(i)
                val s2 = "1" + "0".repeat(s1.length)
                print(s2.toInt(2) - s1.toInt(2))
                return
            }
        }
    }
}