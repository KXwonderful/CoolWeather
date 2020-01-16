package com.wdf.coolweather.ui.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wdf.coolweather.data.WeatherRepository

/**
 * Function:
 * Author: wonderful on 2020/1/13 16:05
 */

class WeatherModelFactory(private val repository: WeatherRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeatherViewModel(repository) as T
    }
}