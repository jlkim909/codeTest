package All

fun main() = with(System.`in`.bufferedReader()){
    data class Player(val point:Int, val name:String)
    val (p, m) = readLine().split(" ").map{it.toInt()}
    val r = Array(p){
        mutableListOf<Player>()
    }

    repeat(p){
        val (point, name) = readLine().split(" ")
        for(room in r){
            if(room.size == 0){
                room.add(Player(point.toInt(), name))
                break
            }else if(point.toInt() - room.first().point in -10..10){
                if(room.size < m) {
                    room.add(Player(point.toInt(), name))
                    break
                }
            }
        }
    }

    for(room in r){
        if(room.size == 0){
            break
        }
        if(room.size == m){
            println("Started!")
        } else{
            println("Waiting!")
        }
        room.sortBy { player ->
            player.name
        }
        for(player in room){
            println("${player.point} ${player.name}")
        }
    }
}