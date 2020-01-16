package com.wdf.coolweather.ui.weather

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wdf.coolweather.MyApplication
import com.wdf.coolweather.data.WeatherRepository
import com.wdf.coolweather.data.model.weather.Weather
import kotlinx.coroutines.launch

/**
 * Function:
 * Author: wonderful on 2020/1/13 16:05
 */

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    var weather = MutableLiveData<Weather>()

    var bingPicUrl = MutableLiveData<String>()

    var refreshing = MutableLiveData<Boolean>()

    var weatherInitialized = MutableLiveData<Boolean>()

    var weatherId = ""

    fun getWeather() {
        launch({
            weather.value = repository.getWeather(weatherId)
            weatherInitialized.value = true
        }, {
            Toast.makeText(MyApplication.context, it.message, Toast.LENGTH_SHORT).show()
        })
        getBingPic(false)
    }

    fun refreshWeather() {
        refreshing.value = true
        launch({
            weather.value = repository.refreshWeather(weatherId)
            refreshing.value = false
            weatherInitialized.value = true
        }, {
            Toast.makeText(MyApplication.context, it.message, Toast.LENGTH_SHORT).show()
        })
        getBingPic(true)
    }

    fun isWeatherCached() = repository.isWeatherCached()

    fun getCachedWeather() = repository.getCacheWeather()

    fun onRefresh() {
        refreshWeather()
    }

    private fun getBingPic(refresh: Boolean) {
        launch({
            bingPicUrl.value = if (refresh) repository.refreshBingPic() else repository.getBingPic()
        }, {
            Toast.makeText(MyApplication.context, it.message, Toast.LENGTH_SHORT).show()
        })
    }

    private fun launch(block: suspend () -> Unit, error: suspend (Throwable) -> Unit) =
        viewModelScope.launch {
            try {
                block()
            } catch (e: Throwable) {
                error(e)
            }
        }
}