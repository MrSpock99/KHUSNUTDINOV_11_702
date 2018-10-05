package Lesson_14

fun main(args: Array<String>) {
    var intex: Int = 0;

    while (intex < 10){
        println("YO :)")
        intex++
    }

    var nums = 1..10

    for (value in nums){
        print(value)
    }
    println()
    for (value in 10 downTo 1){
        print(value)
    }
}
