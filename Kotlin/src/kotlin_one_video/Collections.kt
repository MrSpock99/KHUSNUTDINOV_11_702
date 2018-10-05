package kotlin_one_video

fun main(args: Array<String>) {
    var list1: MutableList<Int> = mutableListOf(1,2,3,4,5)

    val list2: List<Int> = listOf(1,2,3)

    list1.add(6)

    println("1st : ${list1.first()}")
    println("Last : ${list1.last()}")

    println("2nd: ${list1[1]}")

    var list3 = list1.subList(0,3)

    list3.clear()

}