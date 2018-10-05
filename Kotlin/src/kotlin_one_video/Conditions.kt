package kotlin_one_video

fun main(args: Array<String>) {
    val age = 9
    if (age < 5){
        println("Go away!")
    }else if(age == 5){
        println("Come here")
    }

    when(age){
        0,1,3,4 -> println("Go to pre-school")
        5 -> println("Go to kindergarden")
        in 6..17 -> {
            val grade = age - 5
            println("Go to Grade$grade")
        }
        else -> print("LOL")
    }

}