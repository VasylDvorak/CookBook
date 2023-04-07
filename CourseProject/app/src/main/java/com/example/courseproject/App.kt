package com.example.courseproject

import android.app.Application
import com.example.courseproject.di.AppComponent
import com.example.courseproject.di.DaggerAppComponent
import com.example.courseproject.di.modules.AppModule


class App : Application() {
    lateinit var appComponent: AppComponent
    companion object {
        lateinit var instance: App
        var appInstance: App? = null  // Оставил для вызова App.appInstance?.applicationContext из любого места программы
    }



    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }



}
