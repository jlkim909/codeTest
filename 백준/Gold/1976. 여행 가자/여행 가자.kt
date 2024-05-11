package all

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val m = readLine().toInt()
    val parent = IntArray(n){
        it
    }
    val rank = IntArray(n)
    fun find(x:Int) : Int {
        if(parent[x] != x){
            parent[x] = find(parent[x])
        }

        return parent[x]
    }

    fun union(x:Int, y:Int){
        val xRoot = find(x)
        val yRoot = find(y)

        if(xRoot == yRoot) return

        if(rank[xRoot] < rank[yRoot]){
            parent[xRoot] = yRoot
        } else if (rank[xRoot] > rank[yRoot]){
            parent[yRoot] = xRoot
        }else{
            parent[yRoot] = xRoot
            rank[xRoot]+=1
        }
    }

    repeat(n){
        val l = readLine().split(" ").map{it.toInt()}
        for(i in 0..<n){
            if(l[i] == 1){
                union(it, i)
            }
        }
    }

    val path = readLine().split(" ").map{it.toInt() - 1}

    val pp = find(path[0])

    for(i in 1..<m){
        if(pp != find(path[i])){
            print("NO")
            return
        }
    }

    print("YES")
}