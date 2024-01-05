package binarySearch

fun main() = with(System.`in`.bufferedReader()){
    val (n, m) = readLine().split(" ").map{it.toInt()}
    val jewels = mutableListOf<Int>()

    repeat(m){
        jewels.add(readLine().toInt())
    }

    jewels.sort()

    var s = 1
    var e = jewels[m-1]

    var result = e
    while(s <= e) {
        val mid = (s+e)/2
        var temp = n
        for(jewel in jewels){
            if(temp < 0){
                break
            }
            if(jewel > mid){
                temp -= jewel/mid + if(jewel%mid==0) 0 else 1
            }else{
                temp--
            }
        }

        if(temp < 0){
            s = mid + 1
            continue
        }else if(temp > 0){
            e = mid - 1
        }else{
            e = mid - 1
            s = 1
        }

        if(result > mid){
            result = mid
        }
    }

    print(result)
}