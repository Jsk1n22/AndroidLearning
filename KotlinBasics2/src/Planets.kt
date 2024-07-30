fun main() {
    val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
    val solarSystem = rockPlanets + gasPlanets

    println(solarSystem[0])
    println(solarSystem[1])
    println(solarSystem[2])
    println(solarSystem[3])
    println(solarSystem[4])
    println(solarSystem[5])
    println(solarSystem[6])
    println(solarSystem[7])

    for (planet in solarSystem) {
        print("$planet, ")
    }
    println()

    solarSystem[3] = "Little Earth"
    println(solarSystem[3])

    solarSystem.forEach { print("$it, ") }
    println()

    val newSolarSystem = solarSystem + "Pluto"
    println(newSolarSystem[8])

    val solarList:MutableList<String> = solarSystem.toMutableList()
    println(solarList.size)
    println(solarList.get(3))
    println(solarList.indexOf("Earth"))
    println(solarList.indexOf("Pluto"))
    solarList.add("Pluto")
    solarList.add(3, "Theia")
    solarList[3] = "Future Moon"
    println(solarList[3])
    println(solarList[9])
    solarList.removeAt(9)
    solarList.remove("Future Moon")
    println(solarList.contains("Pluto"))
    println("Future Moon" in solarList)

    solarList.forEach { print("$it, ") }

    val solarSet = solarSystem.toMutableSet()
    println(solarSet.size)
    solarSet.add("Pluto")
    println(solarSet.size)
    println("Pluto" in solarSet)
    solarSet.add("Pluto")
    println(solarSet.size)
    solarSet.remove("Pluto")
    println(solarSet.size)
    println(solarSet.contains("Pluto"))

    val moonMap = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )
    println("Map size: ${moonMap.size}")
    moonMap["Pluto"] = 5
    println("Map size: ${moonMap.size}")
    println("Pluto has ${moonMap["Pluto"]} moons")
    println("Mars has ${moonMap.get("Mars")} moons")
    println("Theia has ${moonMap["Theia"]} moons")
    moonMap.remove("Pluto")
    println("Map size: ${moonMap.size}")
    moonMap.put("Jupiter", 78)
    println(moonMap["Jupiter"])
}