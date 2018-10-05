fun main(args: Array<String>) {
    //Can be null
    val st: String? = getSt()

    //Can be null
    val size = st!!.length

    println(size)
}
//Can return null
fun getSt(): String?{
    throw KotlinNullPointerException()
    return "aa"
}