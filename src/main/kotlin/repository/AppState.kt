package repository

import models.Archive
import models.Note

object AppState {
    private val archives: MutableList<Archive> = mutableListOf()

    fun getArchives(): List<Archive> {
        return archives
    }

    fun getArchive(hash: Int): Archive {
        return archives.find { it.hashCode() == hash } ?: archives[0]
    }

    fun getNote(archiveHash: Int, noteHash: Int): Note {
        val archive = getArchive(archiveHash)

        return archive.notes.find { it.hashCode() == noteHash } ?: archive.notes[0]
    }

    fun addArchive(archive: Archive) {
        archives.add(archive)
    }

    fun addNote(archiveHash: Int, note: Note) {
        val archive = getArchive(archiveHash)

        archive.notes.add(note)
    }
}
