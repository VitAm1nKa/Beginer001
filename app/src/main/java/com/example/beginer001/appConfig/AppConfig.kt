package com.example.beginer001.appConfig

import android.app.Application
import com.orm.SugarContext

class BeginerAppConfig: Application() {

    override fun onCreate() {
        super.onCreate()

        SugarContext.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()

        SugarContext.terminate()
    }
}