fun main(){
    var sum = 0
    for(idx in 0..3){
        var second = readln().toInt()
        sum += second
    }
    println(sum/60)
    println(sum%60)
}