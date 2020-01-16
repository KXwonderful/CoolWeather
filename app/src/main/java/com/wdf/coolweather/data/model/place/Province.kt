package com.wdf.coolweather.data.model.place

import com.google.gson.annotations.SerializedName
import org.litepal.crud.LitePalSupport

/**
 * Function:
 * Author: wonderful on 2020/1/14 9:22
 */

class Province(@SerializedName("name") val provinceName: String, @SerializedName("id") val provinceCode: Int) :
    LitePalSupport() {
    @Transient
    val id = 0
}