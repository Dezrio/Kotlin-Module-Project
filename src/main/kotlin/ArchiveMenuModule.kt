class ArchiveMenuModule(moduleName: String)
    : AbstractMenuModule<NoteMenuModule>(moduleName, "Список заметок", listOfModules = mutableListOf()) {
        override val funcName = "Создать заметку"

        override fun funcInvoke() {
            val inputName: String?
            val inputText: String?

            println("Введите наименование заметки")

            inputName = input.nextLine()

            if (inputName.isNullOrEmpty())
                throw  Exception("Наименование не должно быть пустым")

            println("Введите текст заметки")

            inputText = input.nextLine()

            if (inputText.isNullOrEmpty())
                throw  Exception("Текст заметки не должен быть пустым")

            listOfModules.add(NoteMenuModule(inputName, inputText))
        }
}