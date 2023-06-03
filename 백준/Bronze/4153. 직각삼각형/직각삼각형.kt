fun main(){
    while(true) {
        var inp = readln()
        if(inp == "0 0 0") break
        var line = inp.split(" ").map { Math.pow(it.toDouble(), 2.0) }
        var longLine = maxOf(line[0], line[1], line[2])
        if (line[0] + line[1] + line[2] - longLine * 2 == 0.0) println("right") else println("wrong")
    }
}