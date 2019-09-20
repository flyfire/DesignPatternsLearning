package com.solarexsoft.designpatterns.pattern.behavioral.command

/**
 * Created by houruhou on 2019/9/20.
 * Desc:
 */
interface Command {
    fun execute()
}

class Light {
    fun turnOn() {
        println("开灯")
    }

    fun turnOff() {
        println("关灯")
    }
}

class LightOnCommand constructor(private val light: Light) : Command {
    override fun execute() {
        light.turnOn()
    }
}

class LightOffCommand constructor(private val light: Light) : Command {
    override fun execute() {
        light.turnOff()
    }
}

class Staff {
    private val COMMANDS = mutableListOf<Command>()

    fun addCommand(command: Command) {
        COMMANDS.add(command)
    }

    fun executeCommands() {
        COMMANDS.forEach {
            it.execute()
        }
        COMMANDS.clear()
    }
}

fun main() {
    val light = Light()
    val lightOnCommand = LightOnCommand(light)
    val lightOffCommand = LightOffCommand(light)
    val staff = Staff()
    staff.addCommand(lightOnCommand)
    staff.addCommand(lightOffCommand)
    staff.executeCommands()
}
