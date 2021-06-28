package com.example.layoutapp

import android.app.Application
import com.blankj.utilcode.util.CrashUtils

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        CrashUtils.init()
    }
}