package ui

import models.Titled

enum class MenuItemType{
    CREATE, SELECT_ITEM, EXIT
}

sealed class MenuItem(val type: MenuItemType, val title: String, val hash: Int? = null) {
    class Create(private val entityType: String): MenuItem(MenuItemType.CREATE, "Создать $entityType")
    object EXIT: MenuItem(MenuItemType.EXIT, "Выход")
    class DataItem(item: Titled): MenuItem(MenuItemType.SELECT_ITEM, item.title, item.hashCode())
}
