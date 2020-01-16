package com.wdf.coolweather

import android.app.Application
import android.content.Context
import org.litepal.LitePal

/**
 * Function: application
 * Author: wonderful on 2020/1/13 13:48
 */

class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        LitePal.initialize(this)
        context = this
    }

    companion object{
        lateinit var context: Context
    }
}