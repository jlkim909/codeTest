fun main(){
    var s = readln().split(" ").map{it.toInt()}
    var st = isAccepted(s[0])
    var t = isAccepted(s[1])
    if(st && t) print("Accepted")
    else if(!st) print("Wrong Answer")
    else print("Why Wrong!!!")
}

fun isAccepted(num:Int):Boolean{
    var isTrue = true
    repeat(num){
        var answer = readln().split(" ").map{it.toInt()}
        if(answer[0] != answer[1]) isTrue = false
    }
    return isTrue
}