package com.wdf.coolweather.ui

import androidx.lifecycle.ViewModel
import com.wdf.coolweather.data.WeatherRepository

/**
 * Function:
 * Author: wonderful on 2020/1/13 14:24
 */

class MainViewModel(private val repository: WeatherRepository) : ViewModel() {
    fun isWeatherCached() = repository.isWeatherCached()
}