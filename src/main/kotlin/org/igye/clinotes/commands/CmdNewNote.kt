package org.igye.clinotes.commands

import org.igye.clinotes.BASE_NOTES_DIR
import java.io.File
import java.nio.file.Files
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class CmdNewNote : AbstractCmd("nn") {
    override fun processCommand(cmd: String) {
        val curTime = Instant.now().atZone(ZoneId.systemDefault())
        val year = curTime.year.toString()
        val month = curTime.month.value.toString().padStart(2, '0')
        val day = curTime.dayOfMonth.toString().padStart(2, '0')
        val timestampStr = curTime.format(DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss"))
        val dir = File(BASE_NOTES_DIR, "${year}/${month}/${day}")
        if (!dir.exists()) {
            dir.mkdirs()
        }
        var file = File(dir, timestampStr + ".txt")
        var cnt = 0
        while (file.exists()) {
            cnt++
            file = File(dir, timestampStr + "-" + cnt + ".txt")
        }
        Files.createFile(file.toPath())
        println("A new note was created: " + file.absolutePath.replace("\\", "/"))
    }
}