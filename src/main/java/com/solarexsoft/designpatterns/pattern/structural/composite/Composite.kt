package com.solarexsoft.designpatterns.pattern.structural.composite

import java.lang.RuntimeException

/**
 * Created by houruhou on 2019/9/17.
 * Desc:
 */
abstract class CatelogComponent {
    open fun add(item: CatelogComponent) {
        throw RuntimeException("unsupport add method")
    }

    open fun remove(item: CatelogComponent) {
        throw RuntimeException("unsupport remove method")
    }

    open fun getName(): String {
        throw RuntimeException("unsupport getname method")
    }

    open fun getPrice(): Float {
        throw RuntimeException("unsupport getprice method")
    }

    open fun print() {
        throw RuntimeException("unsupport print method")
    }
}

class Course constructor(val courseName: String, val coursePrice: Float) : CatelogComponent() {
    override fun getName() = courseName
    override fun getPrice() = coursePrice
    override fun print() {
        println("name = $courseName, price = $coursePrice")
    }
}

class CourseCatelog(val dirName: String, val level: Int) : CatelogComponent() {
    val items:MutableList<CatelogComponent> = mutableListOf()
    override fun add(item: CatelogComponent) {
        items.add(item)
    }

    override fun remove(item: CatelogComponent) {
        items.remove(item)
    }

    override fun print() {
        println(dirName)
        items.forEach {
            for (i in 0 until level){
                print(" ")
            }
            it.print()
        }
    }
}

fun main() {
    val linux = Course("linux", 45.0f)
    val windows = Course("windows", 35.0f)
    val programming = CourseCatelog("programming", 2)
    val java = Course("java", 55.0f)
    val kotlin = Course("kotlin", 60.0f)
    val python = Course("python", 65.0f)
    programming.add(java)
    programming.add(kotlin)
    programming.add(python)
    val mooc = CourseCatelog("mooc", 1)
    mooc.add(linux)
    mooc.add(windows)
    mooc.add(programming)
    mooc.print()
}