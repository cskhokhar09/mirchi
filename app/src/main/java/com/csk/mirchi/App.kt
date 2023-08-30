package com.csk.mirchi

import android.app.Application
import android.content.Context

class App : Application() {
    private lateinit var context: Context
    override fun onCreate() {
        super.onCreate()
        context = this
    }

    fun getContext(): Context{
        return context
    }

}