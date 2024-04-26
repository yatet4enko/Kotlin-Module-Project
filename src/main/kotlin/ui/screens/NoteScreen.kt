package ui.screens

import models.Note
import repository.AppState
import ui.MenuItem
import ui.MenuItemType

class NoteScreen(private val archiveHash: Int, private val noteHash: Int): Screen() {

    private val note: Note = AppState.getNote(archiveHash, noteHash)

    override var menuItems: List<MenuItem> = listOf(MenuItem.EXIT)

    override fun printContent() {
        println("Заметка ${note.title}")
        println("Контент заметки:")
        println(note.content)
    }

    override fun processSelectedMenuItem(menuItem: MenuItem): Screen? {
        return when (menuItem.type) {
            MenuItemType.EXIT -> NotesScreen(archiveHash)
            else -> null
        }
    }

}
