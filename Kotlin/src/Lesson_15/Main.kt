package Lesson_15

fun main(args: Array<String>) {
    var nums = 1..10

    if (1 in nums){
        println("1 is in nums")
    }

    val chars = 'a'..'z'
    println(isChar('B',chars))

}

fun isChar(char : Char, characters: CharRange) = char in characters