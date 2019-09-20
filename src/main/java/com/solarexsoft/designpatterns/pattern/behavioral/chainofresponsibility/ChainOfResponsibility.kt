package com.solarexsoft.designpatterns.pattern.behavioral.chainofresponsibility

/**
 * Created by houruhou on 2019/9/20.
 * Desc:
 */
data class Course(val name: String, val content: String)

abstract class Approver {
    var nextApprover: Approver? = null
    abstract fun deploy(course: Course)
}

class NameApprover:Approver(){
    override fun deploy(course: Course) {
        if (course.name.isEmpty()){
            println("name is empty,rejected")
        } else {
            println("name not empty,approved")
            nextApprover?.deploy(course)
        }
    }
}

class ContentApprover:Approver() {
    override fun deploy(course: Course) {
        if (course.content.isEmpty()) {
            println("content is empty,rejected")
        } else {
            println("content not empty,approved")
            nextApprover?.deploy(course)
        }
    }
}

fun main() {
    val nameApprover = NameApprover()
    val contentApprover = ContentApprover()
    nameApprover.nextApprover = contentApprover
    val course = Course("linux", "")
    nameApprover.deploy(course)
}

// tomcat javax.servlet.FilterChain Filter doFilter