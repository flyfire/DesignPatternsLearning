package com.solarexsoft.designpatterns.pattern.creational.prototype

import java.util.*

/**
 * Created by houruhou on 2019/9/16.
 * Desc:
 */
data class Pig public constructor(var name: String,var birthday: Date): Cloneable{
    // https://discuss.kotlinlang.org/t/how-to-use-cloneable/2364/3
    public override fun clone(): Any {
        val tmp = super.clone() as Pig
        tmp.birthday = birthday.clone() as Date
        return tmp
    }
}

fun main() {
    val birth = Date(0L)
    val peiqi = Pig("佩奇", birth)
    val xiaozhu = peiqi.clone() as Pig
    xiaozhu.birthday = Date(66666666666)
    println("peiqi = $peiqi")
    println("xiaozhu = $xiaozhu")
}

// Calendar.java clone()
// Cloneable ArrayList HashMap etc
// 原型模式攻击单例：不实现Cloneable,clone方法调用getInstance