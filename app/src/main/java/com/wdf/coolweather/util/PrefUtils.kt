package com.wdf.coolweather.util

import android.content.Context
import com.wdf.coolweather.MyApplication

/**
 * Function:
 * Author: wonderful on 2020/1/13 16:52
 */

object PrefUtils {

    private const val PREF_NAME = "config"

    fun getBoolean(key: String, defaultValue: Boolean = false) =
        MyApplication.context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getBoolean(
            key,
            defaultValue
        )

    fun setBoolean(key: String, value: Boolean = true) {
        MyApplication.context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit()
            .putBoolean(key, value).apply()
    }

    fun getString(key: String, defaultValue: String = "") =
        MyApplication.context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getString(
            key,
            defaultValue
        )

    fun setString(key: String, value: String = "") {
        MyApplication.context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit()
            .putString(key, value).apply()
    }

    fun getInt(key: String, defaultValue: Int = 0) =
        MyApplication.context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getInt(
            key,
            defaultValue
        )

    fun setInt(key: String, value: Int) {
        MyApplication.context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit()
            .putInt(key, value).apply()
    }

    /**
     * remove value with key
     */
    fun remove(key: String) {
        MyApplication.context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit()
            .remove(key).apply()
    }

    /**
     * clear all data
     */
    fun clear() {
        MyApplication.context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit().clear()
            .apply()
    }
}