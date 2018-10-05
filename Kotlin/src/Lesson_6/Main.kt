package Lesson_6

fun main(args: Array<String>) {
    val person = Person("Ayaz","Hero",19)
    println(person.firstName)
    println(person.lastName)
    println(person.age)

    val car = Car(20.5F,10)
    println(car.isNew)

    car.isNew = true
}