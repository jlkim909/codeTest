package All

fun main() = with(System.`in`.bufferedReader()){
    val (n, k) = readLine().split(" ").map{it.toInt()}
    val dq = ArrayDeque<Int>()
    val numCntArr = IntArray(100_001){0}
    var result = 0
    readLine().split(" ").forEach {
        val num = it.toInt()
        numCntArr[num]++
        dq.add(it.toInt())
        if(numCntArr[num] > k){
            if(result < dq.size - 1){
                result = dq.size - 1
            }
            while(dq.first() != num){
                numCntArr[dq.first()]--
                dq.removeFirst()
            }
            numCntArr[dq.first()]--
            dq.removeFirst()
        }
    }
    if(result < dq.size){
        result = dq.size
    }
    print(result)
}