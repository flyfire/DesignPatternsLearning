package com.solarexsoft.designpatterns.principle.singleresponsibility

/**
 * Created by houruhou on 2019/9/15.
 * Desc:
 */
interface Bird {
    fun move(name: String)
}

class FlyBird : Bird {
    override fun move(name: String) {
        println("$name fly")
    }

}

class WalkBird : Bird {
    override fun move(name: String) {
        println("$name walk")
    }

}

fun main() {
    val flyBird = FlyBird()
    flyBird.move("大雁")
    val walkBird = WalkBird()
    walkBird.move("鸵鸟")
}