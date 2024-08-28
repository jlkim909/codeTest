package date_24_9_2

import java.util.TreeMap

fun main() = with(System.`in`.bufferedReader()){
    val testCase = readLine().toInt()
    repeat(testCase) {
        val k = readLine().toInt()
        val treeMap = TreeMap<Int, Int>()
        repeat(k){
            val l = readLine().split(" ")
            val c = l[0]
            val n = l[1].toInt()
            if(c == "I"){
                treeMap[n] = treeMap.getOrDefault(n, 0) + 1
            }else{
                if(treeMap.isNotEmpty()) {
                    val key = if (n == -1) {
                        treeMap.firstKey()
                    } else {
                        treeMap.lastKey()
                    }

                    val keyCnt = treeMap[key]
                    if(keyCnt == 1){
                        treeMap.remove(key)
                    }else{
                        treeMap[key] = keyCnt!! - 1
                    }
                }
            }
        }
        if(treeMap.isEmpty()){
            println("EMPTY")
        }else{
            println("${treeMap.lastKey()} ${treeMap.firstKey()}")
        }
    }
}