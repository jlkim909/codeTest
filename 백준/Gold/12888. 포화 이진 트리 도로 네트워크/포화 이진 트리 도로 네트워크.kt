package all

fun main() = with(System.`in`.bufferedReader()){
    val h = readLine().toInt()

    val d = LongArray(61)

    fun dp(h:Int):Long{
        if(h <= 1){
            return 1
        }
        if(h == 2){
            return 3
        }

        if(d[h] != 0L){
            return d[h]
        }

        d[h] = dp(h-2) + (1L shl h-1)

        return d[h]
    }

    print(dp(h))
}