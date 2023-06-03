fun main(){
    var nm = readln().split(" ").map{it.toInt()}
    var arr = Array(nm[0]){
        it+1
    }
    repeat(nm[1]){
        var ij = readln().split(" ").map{it.toInt()-1}
        var temp = arr[ij[0]]
        arr[ij[0]] = arr[ij[1]]
        arr[ij[1]] = temp
    }
    for(num in arr){
        print("${num} ")
    }
}