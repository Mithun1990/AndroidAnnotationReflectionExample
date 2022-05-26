package com.naim.androidannotationreflexionexample.model

import com.naim.androidannotationreflexionexample.custom_annotation.EatThreeTime
import com.naim.androidannotationreflexionexample.custom_annotation.NameString
import com.naim.androidannotationreflexionexample.custom_annotation.RunImmediately

class Human(@NameString public val name: String, age: Int) {
    @EatThreeTime(times = 3)
    fun eat() {
        println("${name} is eating")
    }

    @RunImmediately
    fun run() {
        println("${name} is running")
    }
}