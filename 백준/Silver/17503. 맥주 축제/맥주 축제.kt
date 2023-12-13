package greedy

import java.util.PriorityQueue

// 간 레벨 최소값을 구하는 문제
// n일 동안 최대 n개 마실수 있음
// 도수 레벨 <= 간 레벨
// 선호도의 합은 채워야함

fun main() = with(System.`in`.bufferedReader()){
    data class BeerLevel(var sum:Int, val level:Int)
    val (n, m, k) = readLine().split(" ").map{it.toInt()}
    val kindOfBeer = Array(k){
        val (p, c) = readLine().split(" ").map{it.toInt()}
        BeerLevel(p,c)
    }
    kindOfBeer.sortBy{
        it.level
    }

    val currentBeerList = PriorityQueue<Int>()
    val list = mutableListOf<BeerLevel>()

    for(i in 0 until n){
        currentBeerList.add(kindOfBeer[i].sum)
    }
    var sum = currentBeerList.sum()
    list.add(BeerLevel(sum,kindOfBeer[n-1].level))

    for(i in n until k){
        val (p, c) = kindOfBeer[i]
        currentBeerList.add(p)
        sum -= currentBeerList.poll()
        sum += p
        if(list.last().level == c){
            list.removeLast()
        }
        list.add(BeerLevel(sum, c))
    }

    if(list.last().sum < m){
        print(-1)
        return
    }
    

    var start = 0
    var end = list.size - 1

    while(start <= end){
        val mid = (start+end)/2
        if(list[mid].sum < m){
            start = mid + 1
        }else if(list[mid].sum > m){
            end = mid - 1
        }else{
            print(list[mid].level)
            return
        }
    }
    if(list[start].sum < m){
        print(list[start+1].level)
    }else{
        print(list[start].level)
    }
}