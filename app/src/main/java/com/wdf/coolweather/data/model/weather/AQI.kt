package com.wdf.coolweather.data.model.weather

/**
 * Function:
 * Author: wonderful on 2020/1/14 11:22
 */

class AQI {

    lateinit var city: AQICity

    inner class AQICity {
        var aqi = ""
        var pm25 = ""
    }
}