package Lesson_8

enum class Color(val colorHex: String, val opacity: Double? = 1.0){
    WHITE("#FFFFFF"),
    BLACK("#23123"),
    RED("#241241fff", 0.5),
    GREEN("#ff11ff11");

    fun some(){
        print("My logic")
    }
}