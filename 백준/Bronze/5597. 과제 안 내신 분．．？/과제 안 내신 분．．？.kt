fun main(){
    var a = Array(31){
        false
    }

    repeat(28){
        val num = readln().toInt()
        a[num] = true
    }

    for(idx in 1 until a.size){
        if(!a[idx]) println(idx)
    }
}