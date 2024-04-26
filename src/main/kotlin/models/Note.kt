package models

import scanNotEmptyText

class Note(
    override val title: String,
    val content: String
): Titled {
    companion object {
        fun scan(): Note {
            return Note(
                scanNotEmptyText(
                    "Введите название заметки:",
                    "Название не может быть пустым",
                ),
                scanNotEmptyText(
                    "Введите контент заметки:",
                    "Контент не может быть пустым",
                ),
            )
        }
    }
}