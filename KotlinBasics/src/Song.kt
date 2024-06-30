class Song(
    private val title: String,
    private val artist: String,
    private val yearPublished: Int
) {
    private var popular: Boolean = false
    private var playCount: Int = 0
        set(value) {
            if (value > 1000) popular = true
            field = value
        }
    /*
    Better
    val isPopular: Boolean
        get() = playCount >= 1000
     */

    fun description() {
        println("$title, performed by $artist, was released in $yearPublished")
        if (popular) println("This song is popular with $playCount plays")
        else println("This song is not popular with $playCount plays")
    }

}

fun main() {
    val song1 = Song("Neverland", "PeterPan", 1968)
    song1.description()
}