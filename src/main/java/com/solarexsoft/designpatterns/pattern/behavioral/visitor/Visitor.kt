package com.solarexsoft.designpatterns.pattern.behavioral.visitor

/**
 * Created by houruhou on 2019/9/20.
 * Desc:
 */
interface IVisitor {
    fun visit(freeCourse: FreeCourse)
    fun visit(payCourse: PayCourse)
}
abstract class Course constructor(open val name:String) {
    abstract fun accept(visitor: IVisitor)
}

class FreeCourse(override val name: String):Course(name) {
    override fun accept(visitor: IVisitor) {
        visitor.visit(this)
    }
}

class PayCourse(override val name: String, val price:Float):Course(name) {
    override fun accept(visitor: IVisitor) {
        visitor.visit(this)
    }
}

class Visitor : IVisitor {
    override fun visit(freeCourse: FreeCourse) {
        println("free course -> ${freeCourse.name}")
    }

    override fun visit(payCourse: PayCourse) {
        println("pay course -> ${payCourse.name} -> ${payCourse.price}")
    }
}

fun main() {
    val freeCourse = FreeCourse("linux")
    val payCourse = PayCourse("java", 500f)
    val courses = mutableListOf<Course>()
    courses.add(freeCourse)
    courses.add(payCourse)
    val visitor = Visitor()
    courses.forEach {
        it.accept(visitor)
    }
}