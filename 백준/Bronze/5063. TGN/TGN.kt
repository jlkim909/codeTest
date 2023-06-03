fun main(){
    var n = readln().toInt()
    repeat(n){
        var rec = readln().split(" ").map{it.toInt()}
        var pay = rec[1]-rec[2]
        if(rec[0] > pay) println("do not advertise")
        else if(rec[0] == pay) println("does not matter")
        else println("advertise")
    }
}