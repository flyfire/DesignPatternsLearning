package com.solarexsoft.designpatterns.pattern.creational.factorymethod

/**
 * Created by houruhou on 2019/9/15.
 * Desc:
 */
interface IVideo {
    fun produce()
}

class JavaVideo : IVideo {
    override fun produce() {
        println("java video")
    }
}

class CppVideo : IVideo {
    override fun produce() {
        println("cpp video")
    }
}
abstract class AVideoFactory{
    abstract fun createVideo():IVideo
}

class JavaVideoFactory: AVideoFactory() {
    override fun createVideo(): IVideo {
        return JavaVideo()
    }
}

class CppVideoFactory: AVideoFactory() {
    override fun createVideo(): IVideo {
        return CppVideo()
    }
}

fun main() {
    val factory = CppVideoFactory()
    factory.createVideo().produce()
}