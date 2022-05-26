package com.naim.androidannotationreflexionexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.naim.androidannotationreflexionexample.custom_annotation.EatThreeTime
import com.naim.androidannotationreflexionexample.custom_annotation.NameString
import com.naim.androidannotationreflexionexample.custom_annotation.RunImmediately
import com.naim.androidannotationreflexionexample.custom_annotation.VeryImportant
import com.naim.androidannotationreflexionexample.model.CustomModel
import com.naim.androidannotationreflexionexample.model.DataModel
import com.naim.androidannotationreflexionexample.model.Human
import com.naim.androidannotationreflexionexample.model.NewHuman

class MainActivity : AppCompatActivity() {
    private val dataModel by lazy { DataModel("This is a data model") }
    private val customModel by lazy { CustomModel("This is a custom model") }
    private val human by lazy { Human("Naim", 31) }
    private val newHuman by lazy {
        NewHuman().apply {
            this.name = "Naim"
            this.age = 31
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (dataModel.javaClass.isAnnotationPresent(VeryImportant::class.java)) {
            println("Data model class is very important")
        } else {
            println("Data model class is not important")
        }

        if (customModel.javaClass.isAnnotationPresent(VeryImportant::class.java)) {
            println("Custom model class is very important")
        } else {
            println("Custom model class is not important")
        }
        val methods = human.javaClass.declaredMethods
        val fields = newHuman.javaClass.declaredFields
        for (method in methods) {
            if (method.isAnnotationPresent(RunImmediately::class.java)) {
                method.invoke(human)
            }
            if (method.isAnnotationPresent(EatThreeTime::class.java)) {
                val annotation = method.getAnnotation(EatThreeTime::class.java)
                for (i in 1..annotation.times) {
                    method.invoke(human)
//                    println("Naim called ${i}")
                }
            }
        }
        newHuman.age
        fields.forEach {
            if (it.isAnnotationPresent(NameString::class.java)) {
                println("The value is ${it}")
            }
        }
    }
}