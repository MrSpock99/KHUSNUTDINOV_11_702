package kotlin_one_video

fun main(args: Array<String>) {
    fun add(num1: Int = 1, num2: Int) = num1 + num2
    print(add(5, 4))
    print(add(num2 = 5))

    fun sayHello(name: String) = println("Hello,$name")
    sayHello("AYaz")

    val (two, three) = nextTwo(1)

    for (x in two..three) {
        println(x)
    }

    val multiply = {num1: Int, num2: Int -> num1 * num2}

}

fun nextTwo(num: Int): Pair<Int, Int> {
    return Pair(num + 1, num + 1)
}

fun getSum(vararg nums: Int): Int {
    var sum = 0
    nums.forEach { x -> sum += x }
    return sum;
}

fun fact(x: Int): Int{
    tailrec fun factTail(y: Int, z: Int):Int{
        if (y == 0)return z;
        else return factTail(y-1,y*z)
    }
    return factTail(x,1)
}