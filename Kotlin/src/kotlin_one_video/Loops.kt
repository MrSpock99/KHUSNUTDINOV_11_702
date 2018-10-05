package kotlin_one_video

import java.util.*

fun main(args: Array<String>) {
    for (x in 1..10){
        println("Loop = $x")
    }

    val rand = Random()
    val magicNum = rand.nextInt(50) + 1

    var guess = 0

    while(magicNum != guess){
        guess += 1
    }
    println("Magi num was = $magicNum")

    for (x in 1..20){
        if (x % 2 == 0){
            continue
        }
    }

    var arr = arrayOf(1,2,3)

    for (x in arr.indices){
        println(x)
    }

    for((index,value) in arr.withIndex()){
        println("Index: $index Value: $value")
    }
}