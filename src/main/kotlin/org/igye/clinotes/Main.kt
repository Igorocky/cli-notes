package org.igye.clinotes

fun readCommand():String {
    print("[ cli-notes > ")
    return readLine()!!
}

fun main(args: Array<String>) {
    var cmd = readCommand()
    while (cmd != "exit") {
        println("You've entered: ${cmd}")
        cmd = readCommand()
    }

}

