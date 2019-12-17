import java.util.*

object Utils {
    fun generateRandomString(length: Int): String? {
        val AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_"
        val rnd = Random()
        val sb = StringBuilder(length)
        for (i in 0 until length) sb.append(AB[rnd.nextInt(AB.length)])
        return sb.toString()
    }
}