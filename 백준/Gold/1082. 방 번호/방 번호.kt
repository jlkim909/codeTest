package date_24_8_12

private var n: Int = 0
private lateinit var p: List<Int>
private val d = Array(51) {
    ""
}

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    p = readLine().split(" ").map{it.toInt()}
    val m = readLine().toInt()

    val k = dp(m)
    if(k[0] == '0'){
        print(0)
    }else{
        print(k)
    }
}

private fun dp(money:Int):String{
    if(money <= 0){
        return ""
    }
    if(d[money] != ""){
        return d[money]
    }

    var maxValue = ""
    for(i in 0..<n){
        if(money - p[i] < 0){
            continue
        }
        val temp = dp(money - p[i])
        val k = compareNumber(temp + i.toString(), i.toString() + temp)
        maxValue = compareNumber(maxValue, k)
    }

    d[money] = maxValue

    return d[money]
}
private fun compareNumber(a: String, b: String): String {
    if (a.isEmpty() || a[0] == '0') {
        return b
    }

    if (a.length > b.length) {
        return a
    } else if (a.length == b.length) {
        repeat(a.length) {
            if (a[it].digitToInt() > b[it].digitToInt()) {
                return a
            }
        }
        return b
    }
    else {
        return b
    }
}
