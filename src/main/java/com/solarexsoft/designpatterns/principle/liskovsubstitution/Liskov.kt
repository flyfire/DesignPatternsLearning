package com.solarexsoft.designpatterns.principle.liskovsubstitution

/**
 * Created by houruhou on 2019/9/15.
 * Desc:
 */
open class Base {
    open fun method(map: HashMap<String, String>){
        println("base hashmap")
    }
}

class Child : Base() {
//    override fun method(map: HashMap<String, String>) {
//        println("child hashmap")
//    }
    fun method(map: Map<String, String>) {
        println("child map")
    }
}

fun main() {
    val child = Child()
    child.method(HashMap())
}