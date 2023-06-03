fun main(){
    var n = readln().toInt()
    for(i in 0 until n){
        repeat(n-i-1){
            print(" ")
        }
        repeat(i*2+1){
            print("*")
        }
        println()
    }
    for(i in 1 until n){
        repeat(i){
            print(" ")
        }
        repeat((n-i)*2-1){
            print("*")
        }
        println()
    }
}