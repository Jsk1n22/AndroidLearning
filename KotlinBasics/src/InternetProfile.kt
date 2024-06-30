fun main() {
    val amanda = Person("Amanda", 33, null, null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}


class Person(
    private val name: String,
    private val age: Int,
    private val hobby: String?,
    private val referrer: Person?
){
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")

        if(hobby!=null) print("Likes to $hobby. ")
        else print("Has no hobby. ")

        if(referrer!=null) println("Has a referrer ${referrer.name} who likes to ${referrer.hobby}.")
        else println ("Has no referrer.")
    }
}