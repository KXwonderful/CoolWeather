package com.wdf.coolweather.data.model.place

import com.google.gson.annotations.SerializedName
import org.litepal.crud.LitePalSupport

/**
 * Function:
 * Author: wonderful on 2020/1/14 9:27
 */

class County(@SerializedName("name") val countyName: String, @SerializedName("weather_id") val weatherId: String) :
    LitePalSupport() {
    @Transient
    val id = 0
    var cityId = 0
}