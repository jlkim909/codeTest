fun main() {
    var t = readln().toInt()
    repeat(t){
        var ve = readln().split(" ").map{it.toInt()}
        println(2+ve[1]-ve[0])
    }
}