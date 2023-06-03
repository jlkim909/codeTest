fun main(){
    var nk = readln().split(" ").map{it.toInt()}
    print(fac(nk[0])/(fac(nk[1])*fac(nk[0]-nk[1])))
}

fun fac(num:Int):Int{
    if(num<=1) return 1
    return fac(num-1) * num
}