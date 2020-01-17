package com.wdf.coolweather.data.db

import com.google.gson.Gson
import com.wdf.coolweather.data.model.weather.Weather
import com.wdf.coolweather.common.util.PrefUtils

/**
 * Function:
 * Author: wonderful on 2020/1/13 14:26
 */

class WeatherDao {

    fun cacheWeatherInfo(weather: Weather?) {
        if (weather == null) return
        PrefUtils.setString("weather", Gson().toJson(weather))
    }

    fun getCachedWeatherInfo(): Weather? {
        val weatherInfo = PrefUtils.getString("weather")
        if ("" != weatherInfo) {
            return Gson().fromJson(weatherInfo, Weather::class.java)
        }
        return null
    }

    fun cacheBingPic(bingPic: String?) {
        if (bingPic == null) return
        PrefUtils.setString("bing_pic", bingPic)
    }

    fun getCachedBingPic(): String? = PrefUtils.getString("bing_pic")
}