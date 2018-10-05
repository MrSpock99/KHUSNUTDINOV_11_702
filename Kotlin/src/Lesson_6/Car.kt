package Lesson_6

class Car(private var weight: Float, private var size: Int) {
    var isNew: Boolean = false
        get() {
            return weight > size
        }
        set(value) {
            if (value){
                print("YEEES")
            }
            field = value
        }
}