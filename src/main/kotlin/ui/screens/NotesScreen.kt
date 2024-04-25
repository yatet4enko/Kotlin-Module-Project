package ui.screens

import models.Archive
import models.Note
import repository.AppState
import ui.MenuItem
import ui.MenuItemType

class NotesScreen(private val archiveHash: Int): Screen() {

    private val archive: Archive = AppState.getArchive(archiveHash)

    override var menuItems: List<MenuItem> = listOf(MenuItem.Create("заметку")) +
            archive.notes.map { MenuItem.DataItem(it) } +
            listOf(MenuItem.EXIT)
    override fun printContent() {
        println("Архив ${archive.title}")
        println("Список заметок:")
    }

    override fun processSelectedMenuItem(menuItem: MenuItem): Screen? {
        return when (menuItem.type) {
            MenuItemType.CREATE -> {
                AppState.addNote(archiveHash, Note.scan())

                NotesScreen(archiveHash)
            }
            MenuItemType.SELECT_ITEM ->  menuItem.hash?.let { NoteScreen(archiveHash, it) }
            MenuItemType.EXIT -> ArchivesScreen()
        }
    }
}