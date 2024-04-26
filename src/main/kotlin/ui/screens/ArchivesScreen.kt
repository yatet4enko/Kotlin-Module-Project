package ui.screens

import models.Archive
import repository.AppState
import ui.MenuItem
import ui.MenuItemType

class ArchivesScreen: Screen() {
    override var menuItems: List<MenuItem> = listOf(MenuItem.Create("архив")) +
            AppState.getArchives().map { MenuItem.DataItem(it) } +
            listOf(MenuItem.EXIT)

    override fun printContent() {
        println("Список архивов:")
    }

    override fun processSelectedMenuItem(menuItem: MenuItem): Screen? {
        return when (menuItem.type) {
            MenuItemType.CREATE -> {
                AppState.addArchive(Archive.scan())

                ArchivesScreen()
            }
            MenuItemType.SELECT_ITEM ->  menuItem.hash?.let { NotesScreen(it) }
            MenuItemType.EXIT -> null
        }
    }
}