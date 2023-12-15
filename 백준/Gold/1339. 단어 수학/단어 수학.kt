package Greedy

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val word = mutableListOf<String>()
    val priorityAlphaNum = mutableMapOf<Char, Int>()
    repeat(n){
        var s = readLine()
        word.add(s)
        s = s.reversed()
        var k = 1
        for(c in s){
            if(priorityAlphaNum[c] != null){
                priorityAlphaNum[c] = priorityAlphaNum[c]?.plus(k)!!
            }else {
                priorityAlphaNum[c] = k
            }
            k*=10
        }
    }

    val sortList = priorityAlphaNum.toList().sortedByDescending { it.second }.toMap()
    var num = 9

    val alphaNum = Array(26){0}
    for(c in sortList){
        if(c.value != 0){
            alphaNum[c.key.code-65] = num--
        }
    }
    
    var result = 0
    for(w in word){
        var wordToNum = 0
        for(c in w){
            wordToNum *= 10
            wordToNum += alphaNum[c.code - 65]
        }
        result += wordToNum
    }
    print(result)
}