fun main(){
    var nwh = readln().split(" ").map{it.toDouble()}
    var isInSize = Math.sqrt(Math.pow(nwh[1],2.0) + Math.pow(nwh[2],2.0))
    repeat(nwh[0].toInt()){
        var size = readln().toInt()
        if(size <= isInSize) println("DA") else println("NE")
    }
}