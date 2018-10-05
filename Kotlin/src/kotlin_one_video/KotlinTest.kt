package kotlin_one_video

fun main(args: Array<String>) {
    println("Hello, world!!")

    val name = "Derek"

    var myAGe = 42

    var bigInt: Int = Int.MAX_VALUE
    var smallInt: Int = Int.MIN_VALUE

    println("bigInt=$bigInt")
    println("smallInt=$smallInt")

    var letterGrade: Char = 'A'
    println("A is a Char:${letterGrade is Char}")

    println("3.14 to Int: ${3.14.toInt()}")
    println("A to Int: ${'A'.toInt()}")
    println("65 to Char: ${65.toChar()}")

    val myName = "Derek Banas"

    val longStr = """This is a
        |long string
    """.trimMargin()

    var fName: String = "Doug"
    var lName: String = "Smith"

    fName = "Smith"

    var fullName = fName + " " + lName

    println(longStr)

    println(lName == fName)



}