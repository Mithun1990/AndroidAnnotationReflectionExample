package com.naim.androidannotationreflexionexample.model

import com.naim.androidannotationreflexionexample.custom_annotation.EatThreeTime
import com.naim.androidannotationreflexionexample.custom_annotation.NameString
import com.naim.androidannotationreflexionexample.custom_annotation.RunImmediately

class NewHuman {
    @NameString
    var name: String = ""
    var age: Int = 0

    @EatThreeTime(times = 3)
    fun eat() {
        println("${name} is eating")
    }

    @RunImmediately
    fun run() {
        println("${name} is running")
    }
}