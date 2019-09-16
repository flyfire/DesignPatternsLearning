package com.solarexsoft.designpatterns.pattern.structural.decorator

/**
 * Created by houruhou on 2019/9/16.
 * Desc:
 */
abstract class ABatterCake {
    abstract fun getDesc(): String
    abstract fun getCost(): Int
}

open class AbstractDecorator public constructor(open var aBatterCake: ABatterCake): ABatterCake() {
    override fun getDesc(): String {
        return aBatterCake.getDesc()
    }

    override fun getCost(): Int {
        return aBatterCake.getCost()
    }
}

class BatterCake : ABatterCake() {
    override fun getDesc(): String {
        return "煎饼"
    }

    override fun getCost(): Int {
        return 6
    }
}

class EggDecorator public constructor(override var aBatterCake: ABatterCake) : AbstractDecorator(aBatterCake) {
    override fun getDesc(): String {
        return "${aBatterCake.getDesc()} 加一个鸡蛋"
    }

    override fun getCost(): Int {
        return aBatterCake.getCost() + 1
    }
}

class SausageDecorator public constructor(override var aBatterCake: ABatterCake) : AbstractDecorator(aBatterCake) {
    override fun getDesc(): String {
        return "${aBatterCake.getDesc()} 加一根香肠"
    }

    override fun getCost(): Int {
        return aBatterCake.getCost() + 2
    }
}

fun main() {
    var batterCake: ABatterCake = BatterCake()
    batterCake = EggDecorator(aBatterCake = batterCake)
    batterCake = SausageDecorator(batterCake)
    batterCake = EggDecorator(batterCake)

    // 可以写个辅助pretty printer来将添加的decorator归类
    // 输出 煎饼 加两个鸡蛋 加一根香肠
    println("${batterCake.getDesc()} costs ${batterCake.getCost()}")
}

// InputStream FilterInputStream
// Reader BufferedReader
