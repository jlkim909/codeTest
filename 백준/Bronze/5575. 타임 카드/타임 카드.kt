fun main(){
    val a = readln().split(" ").map{it.toInt()}
    val b = readln().split(" ").map{it.toInt()}
    val c = readln().split(" ").map{it.toInt()}

    totalTime(a)
    totalTime(b)
    totalTime(c)
}

fun totalTime(a:List<Int>){
    val aStartTime = a[0]*3600 + a[1]*60 + a[2]
    val aEndTime = a[3] *3600 + a[4]*60 + a[5]
    var totalTime = aEndTime - aStartTime

    val hour = totalTime/3600
    totalTime-=hour*3600
    val minute = totalTime/60
    totalTime-=minute*60
    println("${hour} ${minute} ${totalTime}")
}