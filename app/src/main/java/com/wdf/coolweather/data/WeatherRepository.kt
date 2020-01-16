package com.wdf.coolweather.data

import com.wdf.coolweather.data.db.WeatherDao
import com.wdf.coolweather.data.model.weather.Weather
import com.wdf.coolweather.data.network.CoolWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Function:
 * Author: wonderful on 2020/1/13 14:21
 */

class WeatherRepository private constructor(
    private val weatherDao: WeatherDao,
    private val network: CoolWeatherNetwork
) {

    // get weather
    suspend fun getWeather(weatherId: String): Weather {
        var weather = weatherDao.getCachedWeatherInfo()
        if (weather == null) weather = requestWeather(weatherId)
        return weather
    }

    suspend fun refreshWeather(weatherId: String) = requestWeather(weatherId)

    suspend fun getBingPic(): String {
        var url = weatherDao.getCachedBingPic()
        if (url == null) url = requestBingPic()
        return url
    }

    suspend fun refreshBingPic() = requestBingPic()

    fun isWeatherCached() = weatherDao.getCachedWeatherInfo() != null

    fun getCacheWeather() = weatherDao.getCachedWeatherInfo()!!

    /**
     * request weather and save to cache
     */
    private suspend fun requestWeather(weatherId: String) = withContext(Dispatchers.IO) {
        val heWeather = network.fetchWeather(weatherId)
        val weather = heWeather.weather!![0]
        weatherDao.cacheWeatherInfo(weather)
        weather
    }

    /**
     * request bing picture and save to cache
     */
    private suspend fun requestBingPic() = withContext(Dispatchers.IO) {
        val url = network.fetchBinPic()
        weatherDao.cacheBingPic(url)
        url
    }

    companion object {

        private lateinit var instance: WeatherRepository

        fun getInstance(weatherDao: WeatherDao, network: CoolWeatherNetwork): WeatherRepository {
            if (!::instance.isInitialized) {
                synchronized(WeatherRepository::class.java) {
                    if (!::instance.isInitialized) {
                        instance = WeatherRepository(weatherDao, network)
                    }
                }
            }
            return instance
        }
    }
}