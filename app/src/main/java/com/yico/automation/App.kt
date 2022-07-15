package com.yico.automation

import android.app.Application

class App : Application() {

    //单例化的第一种方式：声明一个简单的Application属性
    companion object {
        private lateinit var instance: App
        fun instance() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}