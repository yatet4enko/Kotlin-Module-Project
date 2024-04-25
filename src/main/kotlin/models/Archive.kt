package models

import scanNotEmptyText

class Archive(
    override val title: String,
    val notes: MutableList<Note>
): Titled {
    companion object {
        fun scan(): Archive {
            return Archive(
                scanNotEmptyText(
                    "Введите название архива:",
                    "Название не может быть пустым",
                ),
                mutableListOf()
            )
        }
    }
}
