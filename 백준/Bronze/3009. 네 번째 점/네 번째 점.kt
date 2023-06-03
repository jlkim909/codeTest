fun main(){
    var xList = mutableListOf<Int>()
    var yList = mutableListOf<Int>()
    repeat(3){
        var point = readln().split(" ").map{it.toInt()}
        if(xList.contains(point[0])) xList.remove(point[0])
        else xList.add(point[0])

        if(yList.contains(point[1])) yList.remove(point[1])
        else yList.add(point[1])
    }

    print("${xList[0]} ${yList[0]}")
}