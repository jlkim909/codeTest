package bfs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val tree = Array(n) {
        mutableListOf<Int>()
    }
    var headNode = 0
    var nodeNum = 0
    readLine().split(" ").map {
        val p = it.toInt()
        if (p != -1) {
            tree[p].add(nodeNum++)
        }else{
            headNode = nodeNum++
        }
    }

    val deleteNode = readLine().toInt()
    val q = ArrayDeque<Int>()
    if(deleteNode != headNode){
        q.add(headNode)
        tree.forEach{node ->
            node.removeIf { it == deleteNode }
        }
    }

    var result = 0
    while (q.isNotEmpty()) {
        val node = q.removeFirst()
        if (tree[node].size == 0) {
            result++
        } else {
            for (i in tree[node]) {
                q.add(i)
            }
        }
    }

    print(result)
}