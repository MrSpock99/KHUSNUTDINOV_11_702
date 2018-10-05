package kotlin_one_video

fun main(args: Array<String>) {
    var nullVal: String? = null

    fun myFun(): String? = null

    var nullVal2 = myFun()

    nullVal2!!.length

}