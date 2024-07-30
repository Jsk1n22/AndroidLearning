class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    print("Menu: ")
    cookies.forEach { print("${it.name}, ") }
    println()

    val fullMenu = cookies.map { "${it.name}: $${it.price}" }
    println("Prices: ")
    fullMenu.forEach { println(it) }

    println("Soft baked: ")
    val softBakedMenu = cookies.filter { it.softBaked }
    softBakedMenu.forEach { println("${it.name}: ${it.price}") }

    val groupedMenu = cookies.groupBy { it.softBaked }
    val softBakedMenu2 = groupedMenu[true] ?: emptyList()
    val crunchyMenu = groupedMenu[false] ?: emptyList()
    println("Crunchy: ")
    crunchyMenu.forEach { println("${it.name}: ${it.price}") }

    val totalPrice = cookies.fold(0.0) {acc, it ->
        acc + it.price
    }
    println("Total price: $$totalPrice")

    cookies.sortedByDescending { it.price }
    print("Menu by price: ")
    cookies.forEach { print("${it.name}, ") }

    println()

    cookies.sortedBy { it.name }
    print("Menu by name: ")
    cookies.forEach { print("${it.name}, ") }
}