package com.wdf.coolweather.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * Function:
 * Author: wonderful on 2020/1/14 11:24
 */

class Basic {
    @SerializedName("city")
    var cityName = ""
    @SerializedName("id")
    var weatherId = ""
    lateinit var update: Update

    inner class Update {
        @SerializedName("loc")
        var updateTime = ""

        fun time() = updateTime.split(" ")[1]
    }
}