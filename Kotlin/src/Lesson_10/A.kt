package Lesson_10

class A(override val prop1: Int) : MyInterface {
    override fun fun1() {
        println(2)
    }

    override fun fun2() {
        super.fun2()
        var a: Int = 2

    }
}