package kotlin_one_video

fun main(args: Array<String>) {
    val numList = 1..20

    val evenList = numList.filter { it % 2 == 0 }
    evenList.forEach{println(it)}

    val mult3 = makeMathFunction(3)

    println("5 * 3 = ${mult3(5)}")

    val doubleInt = {x: Int -> x * 2}

    mathOnList(arrayOf(1,2,3,4,5),doubleInt)


}

fun makeMathFunction(num1: Int): (Int) -> Int = {num2 -> num1 * num2}
fun mathOnList(numList: Array<Int>,myFunc: (num: Int) -> Int){
    numList.forEach{println(myFunc(it))}
}