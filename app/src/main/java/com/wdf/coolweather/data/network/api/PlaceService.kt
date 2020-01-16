package com.wdf.coolweather.data.network.api

import com.wdf.coolweather.data.model.place.City
import com.wdf.coolweather.data.model.place.County
import com.wdf.coolweather.data.model.place.Province
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Function:
 * Author: wonderful on 2020/1/14 9:59
 */

interface PlaceService {

    @GET("api/china")
    fun getProvinces(): Call<MutableList<Province>>

    @GET("api/china/{provinceId}")
    fun getCities(@Path("provinceId") provinceId: Int): Call<MutableList<City>>

    @GET("api/china/{provinceId}/{cityId}")
    fun getCounties(@Path("provinceId") provinceId: Int, @Path("cityId") cityId: Int): Call<MutableList<County>>
}