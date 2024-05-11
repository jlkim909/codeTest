package all

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val words = mutableListOf<Pair<String, Int>>()
    val prefixLength = IntArray(n)
    repeat(n){
        words.add(Pair(readLine(), it))
    }

    words.sortBy { it.first }
    fun countSameChar(a: String, b: String): Int {
        var sum = 0
        for (i in 0..<minOf(a.length, b.length)) {
            if (a[i] != b[i]) {
                break
            }
            sum += 1
        }

        return sum
    }

    var maxLength = 0
    for (i in 0..<n - 1) {
        val lg = countSameChar(words[i].first, words[i + 1].first)
        if (maxLength < lg) {
            maxLength = lg
        }
        prefixLength[words[i].second] = maxOf(prefixLength[words[i].second], lg)
        prefixLength[words[i+1].second] = maxOf(prefixLength[words[i+1].second], lg)
    }

    words.sortBy{it.second}
    var isCheck = false
    var pre = ""
    for(i in 0..<n){
        if(!isCheck) {
            if (maxLength == prefixLength[i]) {
                isCheck = true
                pre = words[i].first.slice(0..<maxLength)
                println(words[i].first)
            }
        }else{
            if(maxLength == prefixLength[i] && words[i].first.slice(0..<maxLength) == pre){
                print(words[i].first)
                break
            }
        }
    }
}