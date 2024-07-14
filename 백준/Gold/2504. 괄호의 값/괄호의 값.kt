package start

import java.util.Stack

fun main() = with(System.`in`.bufferedReader()){
    val l = readLine()
    val s = Stack<Pair<Int, Char>>()
    val s2 = Stack<Pair<Int, Int>>()
    l.forEach{
        when(it){
            '(','[' -> {
                val level = if(s.isEmpty()) 0 else s.peek().first + 1
                s.add(Pair(level, it))
            }
            else -> {
                if(s.isEmpty()){
                    print(0)
                    return
                }
                val (level, symbol) = s.pop()
                if(symbol == '(' && it == ']' ||
                    symbol == '[' && it == ')'){
                    print(0)
                    return
                }

                var value = if(symbol == '(') 2 else 3

                while(s2.isNotEmpty()){
                    val frontLevel = s2.peek().first
                    if(frontLevel > level){
                        value *= s2.pop().second
                    }else if(frontLevel == level){
                        value += s2.pop().second
                    }else{
                        break
                    }
                }

                s2.add(Pair(level, value))
            }
        }
    }

    if(s.isEmpty()) {
        print(s2.pop().second)
    }else{
        print(0)
    }
}