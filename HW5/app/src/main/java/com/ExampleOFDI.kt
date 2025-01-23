package com

import kotlin.math.E

fun main (){
    val engine = Engine()
    val electricEngine = ElectricEngine()
    val electricCar =Car(electricEngine)
    val car = Car(engine)
    car.start()

}

class Car (private val engine:Engine) {
  

    fun start() {
        engine.startEngine()
    }
}

open class Engine{
    open fun startEngine () {
        println("Engine is started")
    }
}

class GasEngine : Engine() {
   override fun startEngine (){
      println("Gas engine is started")
    }
}

class ElectricEngine :Engine() {
    override fun startEngine (){
        println("Electric engine is started")
    }
}