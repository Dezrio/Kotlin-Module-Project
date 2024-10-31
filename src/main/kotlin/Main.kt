fun main() {
    try {
        val mainMenuModule = MainMenuModule("Главный модуль приложения")
        mainMenuModule.open()
    }
    catch (e: Exception){
        println("В ходе выполнения программы возникла непредвиденная ошибка. Приносим свои извинения ┐(‘～` )┌")
        println("Сведения об ошибке:")
        println(e.message)
    }
}