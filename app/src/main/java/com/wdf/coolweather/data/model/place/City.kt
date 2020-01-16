package com.wdf.coolweather.data.model.place

import com.google.gson.annotations.SerializedName
import org.litepal.crud.LitePalSupport

/**
 * Function:
 * Author: wonderful on 2020/1/14 9:25
 */

class City(@SerializedName("name") val cityName: String, @SerializedName("id") val cityCode: Int) :
    LitePalSupport() {
    @Transient
    val id = 0
    var provinceId = 0
}