package com.naim.androidannotationreflexionexample.custom_annotation

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class EatThreeTime(val times: Int)