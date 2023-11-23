package All

fun main() = with(System.`in`.bufferedReader()){
    val (n, d, k, c) = readLine().split(" ").map{it.toInt()}

    val belt = IntArray(n){
        readLine().toInt()
    }

    val sushiCnt = IntArray(d+1){
        0
    }

    var result = 0
    var kindNum = 0
    val dq = ArrayDeque<Int>()
    for(i in 0 until k){
        if(sushiCnt[belt[i]] == 0){
            kindNum++
        }
        sushiCnt[belt[i]]++
        dq.add(belt[i])
    }
    if(sushiCnt[c] == 0){
        result = kindNum + 1
    }else{
        result = kindNum
    }
    for(i in k until n){
        val outSushi = dq.removeFirst()
        val inSushi = belt[i]
        dq.add(inSushi)
        sushiCnt[outSushi]--
        if(sushiCnt[outSushi] == 0){
            kindNum--
        }
        sushiCnt[inSushi]++
        if(sushiCnt[inSushi] == 1){
            kindNum++
        }
        var temp = kindNum
        if(sushiCnt[c] == 0){
            temp++
        }
        if(result < temp){
            result = temp
        }
    }

    for(i in 0 until k-1){
        val outSushi = dq.removeFirst()
        val inSushi = belt[i]
        dq.add(inSushi)
        sushiCnt[outSushi]--
        if(sushiCnt[outSushi] == 0){
            kindNum--
        }
        sushiCnt[inSushi]++
        if(sushiCnt[inSushi] == 1){
            kindNum++
        }
        var temp = kindNum
        if(sushiCnt[c] == 0){
            temp++
        }
        if(result < temp){
            result = temp
        }
    }
    print(result)
}
