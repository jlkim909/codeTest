import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private var numList = mutableListOf<String>()
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    gameNum(Array(10){false}, "")

    repeat(br.readLine().toInt()){
        val t1 = StringTokenizer(br.readLine())
        val num = t1.nextToken()
        val strike = t1.nextToken().toInt()
        val ball = t1.nextToken().toInt()
        val newNumList = mutableListOf<String>()
        for(n in numList){
            var sn = 0
            var bn = 0
            for(i in 0..2){
                if(n[i] == num[i]) sn++
                for(j in 0..2){
                    if(i == j) continue
                    if(n[i] == num[j]) bn++
                }
            }
            if(sn == strike && bn ==ball){
                newNumList.add(n)
            }
        }
        numList = newNumList
    }
    print(numList.size)
}

private fun gameNum(isUsed:Array<Boolean>, cn:String){
    if(cn.length == 3){
        numList.add(cn)
        return
    }
    for(i in 1..9){
        if(!isUsed[i]){
            isUsed[i] = true
            gameNum(isUsed, cn+i.toString())
            isUsed[i] = false
        }
    }
}