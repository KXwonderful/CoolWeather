package com.wdf.coolweather.data.network.api

import com.wdf.coolweather.data.model.weather.HeWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Function:
 * Author: wonderful on 2020/1/13 14:59
 */

interface WeatherService {
    @GET("api/weather")
    fun getWeather(@Query("cityid") weatherId: String): Call<HeWeather>

    @GET("api/bing_pic")
    fun getBingPic(): Call<String>
}