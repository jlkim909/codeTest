fun main(){
    var abc = readln().split(" ").map{it.toInt()}.sorted()
    var order = readln().map{
        if(it == 'A') 0
        else if(it == 'B') 1
        else 2
    }
    print("${abc[order[0]]} ${abc[order[1]]} ${abc[order[2]]}")
}