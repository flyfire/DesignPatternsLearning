package com.solarexsoft.designpatterns.principle.interfacesegregation

/**
 * Created by houruhou on 2019/9/15.
 * Desc:
 */
interface IFlyAnimalAction {
    fun fly()
}

interface IEatAnimalAction {
    fun eat()
}

interface ISwimAnimalAction {
    fun swim()
}

class Dog:IEatAnimalAction,ISwimAnimalAction{
    override fun eat() {
        println("dog eat food")
    }

    override fun swim() {
        println("dog swim")
    }
}

fun main(){
    val dog = Dog()
    dog.eat()
    dog.swim()
}