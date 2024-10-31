package Abstractions

import Utils.input
import Utils.waitAnyInput

abstract class AbstractMenuModule<T: IMenuModule>(override val moduleName: String, private val title: String,
                                                  protected val listOfModules: MutableList<T>) :
    IMenuModule {
    private val menu: MutableMap<Int, IMenuModule> = mutableMapOf()

    protected abstract val funcName: String
    protected abstract fun funcInvoke()

    override fun open() {
        var number: String
        var intNumber: Int?

        while(true){
            initMenu()

            number = input.nextLine()
            intNumber = number.toIntOrNull()

            if (!checkNumber(intNumber)){
                waitAnyInput()
                continue
            }

            when (intNumber){
                0 -> invoke()
                menu.size + 1 -> return
                in 1 .. menu.size -> menu[intNumber!! - 1]!!.open()
                else -> {
                    println("Некорректый ввод")
                    waitAnyInput()
                }
            }
        }
    }

    fun invoke() {
        try{
            funcInvoke()
        }
        catch(e: Exception) {
            println(e.message)
            waitAnyInput()
        }
    }

    private fun initMenu() {
        menu.clear()

        println("$title:")
        println("0. $funcName")

        if (listOfModules.any())
            for(module in listOfModules){
                menu[menu.size] = module
                println("${menu.size}. ${module.moduleName}")
            }

        println("${menu.size + 1}. Выход")
    }

    private fun checkNumber(number: Int?): Boolean{
            if (number == null){
            println("Вводимый символ должен быть числом")
            return false
        }

        if (number < 0 || number > menu.size + 1){
            println("Введённое число выходит за диапазон списка команд")
            return false
        }

        return true
    }
}