package kotlin_one_video

fun main(args: Array<String>) {

    val bowser = Animal("Bowser",20.0,13.5)
    bowser.getInfo()

    val spot = Dog("Spot",20.0,14.4,"Ayaz")
    spot.getInfo()

    val bird = Bird("Twitty",true)
    bird.fly(10.2)

}

open class Animal(val name: String,
                  var height: Double,
                  var weight: Double){
    init {
        val regex = Regex(".*\\d+.*")

        require(!name.matches(regex)){"Animal name can't contain numbers"}
        require(height > 0){"Height must be greater than zero"}
        require(weight > 0){"Weight must be greater then 0"}

    }

    open fun getInfo() {
        println("$name is $height tall and weighs $weight")
    }
}

class Dog(name: String,
          height: Double,
          weight: Double,
          var owner: String) : Animal(name,height,weight){
    override fun getInfo(){
        println("$name is $height tall and weighs $weight and it's owner is $owner")
    }
}

interface Flyable{
    var flies: Boolean
    fun fly(distMile: Double)
}

class Bird(private val name: String, override var flies: Boolean = true)
    : Flyable{
    override fun fly(distMile: Double) {
        if (flies){
            println("$name flies $distMile miles")
        }
    }

}
