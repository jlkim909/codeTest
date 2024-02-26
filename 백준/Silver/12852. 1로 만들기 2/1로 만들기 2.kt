package dp

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val d = IntArray(1_000_001)
    val previous = IntArray(n+1)
    previous[1] = 1
    d[1] = 0
    for(i in 2..n){
        d[i] = d[i-1] + 1
        previous[i] = i-1
        if(i % 3 == 0 && d[i] > d[i/3] + 1){
            d[i] = d[i/3] + 1
            previous[i] = i/3
        }

        if(i % 2 == 0 && d[i] > d[i/2] + 1){
            d[i] = d[i/2] + 1
            previous[i] = i/2
        }
    }

    println(d[n])

    var k = n
    print("$n ")
    while(k != 1){
        print("${previous[k]} ")
        k = previous[k]
    }
}