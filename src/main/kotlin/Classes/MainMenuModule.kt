package Classes

import Abstractions.AbstractMenuModule
import Utils.input

class MainMenuModule (moduleName: String)
    : AbstractMenuModule<ArchiveMenuModule>(moduleName, "Список архивов", listOfModules = mutableListOf()) {
    override val funcName = "Создать архив"

    override fun funcInvoke() {
        val inputName: String?

        println("Введите наименование архива")

        inputName = input.nextLine()

        if (inputName.isNullOrEmpty())
            throw  Exception("Наименование не должно быть пустым")

        listOfModules.add(ArchiveMenuModule(inputName))
    }
}