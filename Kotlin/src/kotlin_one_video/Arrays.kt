package kotlin_one_video

fun main(args: Array<String>) {
    var myArray = arrayOf(1,1.23,"Doug")
    for(item in myArray){
        println(item)
    }

    var sqArray = Array(5,{x -> x*x})
    sqArray.forEach { x -> print(x) }

    //Ranges

    val oneToTen = 1..10
    val alpha = "A".."Z"

    println("R is in Alpha=${"R" in alpha}")

    val tenTo1 = 10.downTo(1)
    val twoTo20 = 2.rangeTo(20)
    val rng3 = oneToTen.step(3)

    for(i in rng3){
        println(i)
    }
    for(i in rng3.reversed()){
        println(i)
    }
}