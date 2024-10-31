package Classes

import Abstractions.IMenuModule
import Utils.waitAnyInput

class NoteMenuModule(override val moduleName: String, val text: String) : IMenuModule {
    override fun open() {
        println("$moduleName: $text")
        waitAnyInput()
    }
}