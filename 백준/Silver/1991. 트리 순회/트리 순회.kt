package binarySearch

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.TreeMap
import java.util.TreeSet

data class Node(var left:Int, var right:Int)
val arr = Array(30){
    Node(-1, -1)
}
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n){
        val t1 = StringTokenizer(br.readLine())
        var c = t1.nextToken().single()
        var l = t1.nextToken().single()
        var r = t1.nextToken().single()
        val nodeIdx = c.code - 65
        if(l != '.'){
            arr[nodeIdx].left = l.code-65
        }
        if(r != '.'){
            arr[nodeIdx].right = r.code-65
        }
    }
    preorder(0)
    println()
    inorder(0)
    println()
    postorder(0)
}

private fun preorder(x:Int){
    if(x == -1) return
    print((x+65).toChar())
    preorder(arr[x].left)
    preorder(arr[x].right)
}

private fun inorder(x:Int) {
    if (x == -1) return
    inorder(arr[x].left)
    print((x+65).toChar())
    inorder(arr[x].right)
}
private fun postorder(x:Int) {
    if (x == -1) return
    postorder(arr[x].left);
    postorder(arr[x].right);
    print((x+65).toChar())
}