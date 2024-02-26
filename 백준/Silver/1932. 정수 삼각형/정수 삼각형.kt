package dp

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    val board = Array(510){
        IntArray(510){-1}
    }

    val d = Array(510){
        IntArray(510){-1}
    }

    repeat(n){i ->
        readLine().split(" ").mapIndexed{idx, value ->
            board[i+1][idx+1] = value.toInt()
        }
    }

    d[1][1] = board[1][1]
    fun dfs(r:Int, c:Int):Int{
        if(r < 1){
            return 0
        }

        if(d[r][c] != -1){
            return d[r][c]
        }

        val v1 = if(c-1 > 0) dfs(r-1, c-1) else 0
        val v2 = if(c <= r) dfs(r-1, c) else 0

        d[r][c] = maxOf(v1, v2) + board[r][c]

        return d[r][c]
    }

    var result = 0
    dfs(n+1,0)
    for(i in 0..n){
        result = maxOf(dfs(n, i), result)
    }

    print(result)
}