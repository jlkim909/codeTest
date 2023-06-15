fun main(){
    val arr = Array(101){
        it
    }
    val nm = readln().split(" ").map{it.toInt()}
    repeat(nm[1]){
        val ij = readln().split(" ").map{it.toInt()}
        arr.reverse(ij[0], ij[1]+1)
    }

    for(idx in 1..nm[0]){
        print("${arr[idx]} ")
    }
}
