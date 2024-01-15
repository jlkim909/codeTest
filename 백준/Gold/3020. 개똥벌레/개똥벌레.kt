package binarySearch

fun main() = with(System.`in`.bufferedReader()){
    val (n, h) = readLine().split(" ").map{it.toInt()}
    val cave = Array(2){
        Array(h + 1){
            0
        }
    }

    repeat(n){
        cave[it%2][readLine().toInt()]++
    }

    val s = IntArray(h){
        0
    }
    s[0] = n/2

    var result = 100_001

    for(i in 1..<h){
        s[i] = s[i-1] - cave[0][i] + cave[1][h-i]
        if(result > s[i]){
            result = s[i]
        }
    }

    print("$result ${s.count { it == result }}")
}