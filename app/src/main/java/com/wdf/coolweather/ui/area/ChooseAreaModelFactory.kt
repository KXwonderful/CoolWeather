package com.wdf.coolweather.ui.area

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wdf.coolweather.data.PlaceRepository

/**
 * Function:
 * Author: wonderful on 2020/1/14 9:20
 */

class ChooseAreaModelFactory(private var repository: PlaceRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ChooseAreaViewModel(repository) as T
    }
}
