package com.solarexsoft.designpatterns.pattern.behavioral.memento

import java.util.*

class InputText {
    private val text = StringBuilder()

    fun getText() = text.toString()

    fun append(input: String) = text.append(input)

    fun setText(text: String) = this.text.replace(0, this.text.length, text)

    override fun toString(): String = text.toString()
}

class SnapshotHolder {
    private val snapshots = Stack<InputText>()

    fun popSnapshot(): InputText = snapshots.pop()

    fun pushSnapshot(inputText: InputText) {
        val deepCloneInputText = InputText()
        deepCloneInputText.setText(inputText.getText())
        println("push deepCloneInputText = $deepCloneInputText")
        snapshots.push(deepCloneInputText)
        println("push $snapshots")
    }

    fun getSnapshots() = snapshots
}

fun main() {
    val inputText = InputText()
    val snapshotsHolder = SnapshotHolder()
    val scanner = Scanner(System.`in`)
    while (scanner.hasNext()) {
        val input = scanner.next()
        println("----input----$input")
        if (input.equals(":list")) {
            println(inputText.getText())
        } else if (input.equals(":undo")) {
            val snapshot = snapshotsHolder.popSnapshot()
            println("-----snapshot-------$snapshot")
            inputText.setText(snapshot.getText())
        } else {
            snapshotsHolder.pushSnapshot(inputText)
            println("----------snapshotsholder-------${snapshotsHolder.getSnapshots()}")
            inputText.append(input)
        }
    }
}