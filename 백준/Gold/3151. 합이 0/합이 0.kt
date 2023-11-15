package binarySearch

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val s = readLine().split(" ").map{it.toInt()}
    val students = Array(n){
        s[it]
    }
    students.sort()

    var result = 0L
    for(i in 0..n-3){
        var start = i+1
        var end = n-1
        var cnt = 0
        while(start < end) {
            var sum = students[start] + students[end] + students[i]
            if(sum == 0){
                if(students[start] == students[end]){
                    result += end-start
                    cnt = 0
                } else{
                    if(cnt == 0) {
                        var k = end
                        while(k > start && students[start] + students[k--] + students[i] == 0
                        ) {
                            cnt++
                        }
                    }
                    result += cnt
                }
                start++
            }else if (sum < 0) {
                start++
                cnt = 0
            } else{
                end--
                cnt = 0
            }
        }
    }
    print(result)
}