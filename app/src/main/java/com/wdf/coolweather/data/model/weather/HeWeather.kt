package com.wdf.coolweather.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * Function:
 * Author: wonderful on 2020/1/13 15:01
 */

class HeWeather {
    @SerializedName("HeWeather")
    var weather: List<Weather>? = null
}