package com.wdf.coolweather.data.db

import com.wdf.coolweather.data.model.place.City
import com.wdf.coolweather.data.model.place.County
import com.wdf.coolweather.data.model.place.Province
import org.litepal.LitePal

/**
 * Function:
 * Author: wonderful on 2020/1/14 9:21
 */

class PlaceDao {

    fun getProvinceList(): MutableList<Province> = LitePal.findAll(Province::class.java)

    fun getCityList(provinceId: Int): MutableList<City> =
        LitePal.where("provinceId = ?", provinceId.toString()).find(City::class.java)

    fun getCountyList(cityId: Int): MutableList<County> =
        LitePal.where("cityId = ?", cityId.toString()).find(County::class.java)

    fun saveProvinceList(provinceList: List<Province>?) {
        if (provinceList != null && provinceList.isNotEmpty()) {
            LitePal.saveAll(provinceList)
        }
    }

    fun saveCityList(cityList: List<City>?) {
        if (cityList != null && cityList.isNotEmpty()) {
            LitePal.saveAll(cityList)
        }
    }

    fun saveCountyList(countList: List<County>?) {
        if (countList != null && countList.isNotEmpty()) {
            LitePal.saveAll(countList)
        }
    }
}