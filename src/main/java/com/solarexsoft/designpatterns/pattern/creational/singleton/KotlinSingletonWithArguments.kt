package com.solarexsoft.designpatterns.pattern.creational.singleton


/**
 * Created by houruhou on 2019/9/16.
 * Desc:
 */
// kotlin singleton with arguments: https://medium.com/@BladeCoder/kotlin-singletons-with-argument-194ef06edd9e
open class SingletonHolder<out T : Any, in A>(creator: (A) -> T) {
    private var creator: ((A) -> T)? = creator
    @Volatile
    private var instance: T? = null

    fun getInstance(arg: A): T {
        val i = instance
        if (i != null) {
            return i
        }
        return synchronized(this) {
            val tmp = instance
            if (tmp != null) {
                tmp
            } else {
                val created = creator!!(arg)
                instance = created
                creator = null
                created
            }
        }
    }
}

class Manager private constructor(context: String) {
    init {
        println(context)
    }

    companion object : SingletonHolder<Manager, String>(::Manager)
}

fun main() {
    Manager.getInstance("solarex")
}

// Rumtime.java
// java.awt.Desktop.java getDesktop