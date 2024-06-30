open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(): Phone(){
    private var isFolded:Boolean = true
    override fun switchOn() {
        if (!isFolded) super.switchOn()
    }

    fun fold() {
        isFolded = true
    }

    fun unfold() {
        isFolded = false
    }
}

fun main() {
    var flipPhone = FoldablePhone()

    flipPhone.switchOn()
    flipPhone.checkPhoneScreenLight()
    flipPhone.unfold()
    flipPhone.switchOn()
    flipPhone.checkPhoneScreenLight()
}