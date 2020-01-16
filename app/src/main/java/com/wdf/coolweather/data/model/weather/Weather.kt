package com.wdf.coolweather.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * Function:
 * Author: wonderful on 2020/1/13 14:28
 */

class Weather {
    var status = ""
    lateinit var basic: Basic
    lateinit var aqi: AQI
    lateinit var now: Now
    lateinit var suggestion: Suggestion
    @SerializedName("daily_forecast")
    lateinit var forecastList: List<Forecast>
}