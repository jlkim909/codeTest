// p[1] = 1
// p[2] = 1
// p[3] = 1
// p[4] = p[1]+[2] = 2
// p[5] = p[2]+p[3] = 2
// p[6] = p[3]+p[4] = 3
// p[7] = p[4]+[5] = 4
// p[8] = p[5]+p[6] = 5
// p[9] = p[6]+p[7] = 7
// p[n] = p[n-3]+p[n-2]

val p = Array<Long>(101){
    0
}
fun main(){
    p[0]=0
    p[1]=1
    p[2]=1
    for(n in 3..100){
        p[n] = p[n-3]+ p[n-2]
    }
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        println(p[n])
    }
}