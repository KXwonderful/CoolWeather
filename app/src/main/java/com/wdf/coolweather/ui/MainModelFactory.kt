package com.wdf.coolweather.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wdf.coolweather.data.WeatherRepository

/**
 * Function:
 * Author: wonderful on 2020/1/13 14:13
 */

class MainModelFactory(private val repository: WeatherRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}