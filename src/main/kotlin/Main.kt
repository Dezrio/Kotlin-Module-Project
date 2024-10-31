fun main() {
    try {
        val mainMenuModule = MainMenuModule("Главный модуль приложения")
        mainMenuModule.open()
    }
    catch (e: Exception){
        println("В ходе выполнения программы возникла непредвиденная ошибка. Приносим свои взвинения ┐(‘～` )┌")
        println("Сведени об ошибке:")
        println(e.message)
    }
}