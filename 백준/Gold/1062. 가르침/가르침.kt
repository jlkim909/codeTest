package date_24_7

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val alpha = BooleanArray(26)
    alpha['a' - 'a'] = true
    alpha['t' - 'a'] = true
    alpha['i' - 'a'] = true
    alpha['c' - 'a'] = true
    alpha['n' - 'a'] = true
    var result = 0

    val words = Array(n) {
        readLine()
    }

    fun dfs(start: Int, t: Int) {
        if (t < 0) {
            return
        }

        if (t == 0) {
            var cnt = 0
            for(word in words){
                var check = true
                for(c in word){
                    if(!alpha[c - 'a']){
                        check = false
                        break
                    }
                }
                if(check) {
                    cnt += 1
                }
            }
            if(result < cnt) result = cnt
            return
        }

        for(i in start..<26){
            if(alpha[i]) continue

            alpha[i] = true
            dfs(i + 1, t - 1)
            alpha[i] = false
        }
    }

    dfs(0, k - 5)
    print(result)
}