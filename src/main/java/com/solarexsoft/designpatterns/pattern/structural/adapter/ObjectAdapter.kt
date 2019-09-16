package com.solarexsoft.designpatterns.pattern.structural.adapter


/**
 * Created by houruhou on 2019/9/16.
 * Desc:
 */
interface ObjectTarget {
    fun request()
}

class ObjectAdaptee {
    fun adapteeRequest() {
        println("adaptee request")
    }
}

class ObjectAdapter public constructor(): ObjectTarget{
    private val objectAdaptee: ObjectAdaptee = ObjectAdaptee()
    override fun request() {
        objectAdaptee.adapteeRequest()
    }
}

class ConcreteObjectTarget : ObjectTarget{
    override fun request() {
        println("concrete request")
    }
}
fun main(){
    val concreteObjectTarget = ConcreteObjectTarget()
    concreteObjectTarget.request()
    val objectAdapter = ObjectAdapter()
    objectAdapter.request()
}

// XmlAdapter