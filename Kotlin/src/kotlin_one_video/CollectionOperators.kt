package kotlin_one_video

fun main(args: Array<String>){
    val numList = 1..20

    val listSum = numList.reduce{x,y -> x + y}
    println("listSum = $listSum")

    val listSumFold = numList.fold(5){x,y -> x + y}
    println("listSumFold = $listSumFold")

    println("Any even number : ${numList.any{it % 2 == 0}}")
    println("All even number : ${numList.all{it % 2 == 0}}")

    val bigger3 = numList.filter { it > 3 }
    bigger3.forEach { println(it) }

    val times7 = numList.map{it * 7}
    times7.forEach { println(it) }
}
