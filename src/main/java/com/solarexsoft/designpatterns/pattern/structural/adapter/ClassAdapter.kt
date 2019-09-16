package com.solarexsoft.designpatterns.pattern.structural.adapter

/**
 * Created by houruhou on 2019/9/16.
 * Desc:
 */
interface ClassTarget {
    fun request()
}

open class ClassAdaptee {
    fun adapteeRequest() {
        println("adaptee request")
    }
}

class ConcreteClassTarget : ClassTarget {
    override fun request() {
        println("concrete request")
    }
}

class ClassAdapter : ClassAdaptee(), ClassTarget {
    override fun request() {
        adapteeRequest()
    }
}

fun main() {
    val concreteClassTarget = ConcreteClassTarget()
    concreteClassTarget.request()

    val adapter = ClassAdapter()
    adapter.request()
}