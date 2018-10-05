package Lesson_16

fun main(args: Array<String>) {
    val person1 = Person("Ayaz",19)
    val person2 = person1.copy("Pidor")

    person2.age = 12

    println(person1)
    println(person2)

    val (name) = person1

    println(name)
}