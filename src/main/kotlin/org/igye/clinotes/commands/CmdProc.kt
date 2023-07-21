package org.igye.clinotes.commands

interface CmdProc {
    val name:String
    fun processCommand(cmd:String)
}