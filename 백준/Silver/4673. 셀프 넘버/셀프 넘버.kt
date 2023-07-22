fun main(){
    val isSelfNum = Array(10001){
        true
    }

    for(i in 1..10000){
        var num = i
        var temp = num
        while (temp > 0) {
            num += temp % 10
            temp /= 10
        }
        if(num>10000){
            continue
        }
        isSelfNum[num]=false
    }

    for(i in 1..10000){
        if(isSelfNum[i]){
            println(i)
        }
    }
}
