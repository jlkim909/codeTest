package date_24_7_29

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val boardMin = Array(n){
        IntArray(3)
    }

    val boardMax = Array(n){
        IntArray(3)
    }

    repeat(n){i ->
        readLine().split(" ").mapIndexed{j, num ->
            boardMin[i][j] = num.toInt()
            boardMax[i][j] = num.toInt()
        }
    }

    for(i in 1..<n){
        boardMax[i][0] += maxOf(boardMax[i-1][0], boardMax[i-1][1])
        boardMax[i][1] += maxOf(boardMax[i-1][0], boardMax[i-1][1], boardMax[i-1][2])
        boardMax[i][2] += maxOf(boardMax[i-1][1], boardMax[i-1][2])

        boardMin[i][0] += minOf(boardMin[i-1][0], boardMin[i-1][1])
        boardMin[i][1] += minOf(boardMin[i-1][0], boardMin[i-1][1], boardMin[i-1][2])
        boardMin[i][2] += minOf(boardMin[i-1][1], boardMin[i-1][2])
    }

    print("${maxOf(boardMax[n-1][0], boardMax[n-1][1], boardMax[n-1][2])} ")
    print("${minOf(boardMin[n-1][0], boardMin[n-1][1], boardMin[n-1][2])}")
}