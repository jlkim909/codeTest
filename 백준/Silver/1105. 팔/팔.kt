package All

fun main() = with(System.`in`.bufferedReader()){
    var (l, r) = readLine().split(" ")

    if(l.length != r.length){
        print(0)
    }else{
        var result = 0
        for(i in l.indices){
            if(l[i] != r[i]){
                break
            }
            if(l[i] == '8' && r[i] == '8'){
                result++
            }
        }
        print(result)
    }
}