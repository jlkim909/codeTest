package all

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val chart = IntArray(n){
        readLine().toInt()
    }
    var isVisited = BooleanArray(n+1)

    for(i in 1..n){
        if(!isVisited[i]){
            val tempVisited = isVisited.copyOf()
            tempVisited[i] = true
            var next = chart[i-1]
            while(!tempVisited[next]){
                tempVisited[next] = true
                next = chart[next-1]
            }

            if(i == next){
                isVisited = tempVisited.copyOf()
            }
        }
    }

    val bw = System.out.bufferedWriter()
    var sum = 0
    for(i in 1..n){
        if(isVisited[i]){
            sum += 1
            bw.write("$i\n")
        }
    }

    println(sum)
    bw.flush()
    bw.close()
}