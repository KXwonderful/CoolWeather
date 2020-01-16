package com.wdf.coolweather.data.db

/**
 * Function:
 * Author: wonderful on 2020/1/13 15:55
 */

object CoolWeatherDatabase {

    private var placeDao: PlaceDao? = null

    private var weatherDao: WeatherDao? = null

    fun getPlaceDao(): PlaceDao {
        if (placeDao == null) placeDao = PlaceDao()
        return placeDao!!
    }

    fun getWeatherDao(): WeatherDao {
        if (weatherDao == null) weatherDao = WeatherDao()
        return weatherDao!!
    }
}