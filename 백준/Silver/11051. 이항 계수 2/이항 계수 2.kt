package dp

fun main() = with(System.`in`.bufferedReader()){
    val (n, k) = readLine().split(" ").map{it.toInt()}
    val d = IntArray(1001){
        0
    }

    fun primeFactorization(num:Int):MutableList<Int>{
        var temp = 2
        var current = num
        val list = mutableListOf<Int>()
        while(current >= temp){
            if(current%temp == 0){
                current/=temp
                list.add(temp)
            }else{
                temp++
            }
        }

        return list
    }

    for(i in k+1..n){
        val addList = primeFactorization(i)
        for (j in addList) {
            d[j]++
        }
        val removeList = primeFactorization(i - k)
        for (j in removeList) {
            d[j]--
        }
    }

    var sum = 1
    for(i in 2..1000){
        repeat(d[i]){
            sum*=i
            sum%=10_007
        }
    }
    println(sum)
}