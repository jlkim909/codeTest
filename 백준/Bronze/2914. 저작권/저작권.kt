fun main(){
    val song = readln().split(" ").map{it.toInt()}
    print(song[0]*(song[1]-1) + 1)
}