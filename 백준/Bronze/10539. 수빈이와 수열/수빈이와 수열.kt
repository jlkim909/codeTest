fun main(){
    var n = readln().toInt()
    var b = readln().split(" ").map{it.toInt()}
    var sum = 0

    repeat(n){
        print("${b[it]*(it+1) - sum} ")
        sum = b[it]*(it+1)
    }
}