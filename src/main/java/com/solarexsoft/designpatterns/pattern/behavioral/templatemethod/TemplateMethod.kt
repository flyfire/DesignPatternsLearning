package com.solarexsoft.designpatterns.pattern.behavioral.templatemethod

/**
 * Created by houruhou on 2019/9/19.
 * Desc:
 */
abstract class ACourse {
    fun makeCourse() {
        makePPT()
        makeVideo()
        if (needWriteAtricle()) {
            makeArticle()
        }
        packageCourse()
    }

    fun makePPT() {
        println("make ppt")
    }
    fun makeVideo() {
        println("make video")
    }

    fun makeArticle() {
        println("make article")
    }

    open fun needWriteAtricle():Boolean {
        return false
    }

    abstract fun packageCourse()
}

class LinuxCourse : ACourse() {
    override fun packageCourse() {
        println("package linux")
    }
}

class JavaCourse : ACourse() {
    override fun needWriteAtricle(): Boolean {
        return true
    }

    override fun packageCourse() {
        println("package java")
    }
}

fun main() {
    val linux: ACourse = LinuxCourse()
    linux.makeCourse()
    println("-------------")
    val java: ACourse = JavaCourse()
    java.makeCourse()
}

// AbstractList
// AbstractMap addAll