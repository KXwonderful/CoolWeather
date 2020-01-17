package com.wdf.coolweather.util

import com.wdf.coolweather.data.PlaceRepository
import com.wdf.coolweather.data.WeatherRepository
import com.wdf.coolweather.data.db.CoolWeatherDatabase
import com.wdf.coolweather.data.network.CoolWeatherNetwork
import com.wdf.coolweather.ui.area.ChooseAreaModelFactory
import com.wdf.coolweather.ui.weather.WeatherModelFactory

/**
 * Function:
 * Author: wonderful on 2020/1/13 14:12
 */

object InjectorUtil {

    private fun getPlaceRepository() = PlaceRepository.getInstance(
        CoolWeatherDatabase.getPlaceDao(),
        CoolWeatherNetwork.getInstance()
    )

    private fun getWeatherRepository() = WeatherRepository.getInstance(
        CoolWeatherDatabase.getWeatherDao(),
        CoolWeatherNetwork.getInstance()
    )

    fun getChooseAreaModelFactory() = ChooseAreaModelFactory(getPlaceRepository())

    fun getWeatherModelFactory() = WeatherModelFactory(getWeatherRepository())
}