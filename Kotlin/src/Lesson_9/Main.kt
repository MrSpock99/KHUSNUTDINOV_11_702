package Lesson_9

import Lesson_8.Color

fun main(args: Array<String>) {
    var R = getFavoriteColor(Color.BLACK)

    when {
        (1 > 2) || (2 > 5) -> println("AAA")
        (1 < 2) || (2 < 5) -> println("BBBB")
    }

    print(R)
}

fun getFavoriteColor(color: Color) = when (color) {
    Color.GREEN -> "GREEN"
    Color.BLACK, Color.WHITE -> "BLACK OR WHITE"
    Color.RED -> "RED"
    else -> "None"
}