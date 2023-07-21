package org.igye.clinotes

import org.igye.clinotes.commands.CmdNewNote

val allCommands = listOf(
    CmdNewNote()
)

fun readCommand():String {
    print("[ cli-notes >>> ")
    return readLine()!!
}

fun main(args: Array<String>) {
    var cmd: String = readCommand()
    while (cmd != "exit") {
        cmd = cmd.trim()
        if (cmd.length > 0) {
            val cmdName = cmd.split(' ')[0]
            val cmdProc = allCommands.find { it.name == cmdName }
            if (cmdProc != null) {
                cmdProc.processCommand(cmd)
            } else {
                println("Error: could not recognize the command.")
            }
        }
        cmd = readCommand()
    }

}

