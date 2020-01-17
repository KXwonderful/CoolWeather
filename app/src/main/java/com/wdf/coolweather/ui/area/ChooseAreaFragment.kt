package com.wdf.coolweather.ui.area

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wdf.coolweather.R
import com.wdf.coolweather.common.base.fragment.BaseBackFragment
import com.wdf.coolweather.databinding.ChooseAreaBinding
import com.wdf.coolweather.event.RefreshWeatherEvent
import com.wdf.coolweather.ui.weather.WeatherFragment
import com.wdf.coolweather.util.InjectorUtil
import kotlinx.android.synthetic.main.choose_area.*
import kotlinx.android.synthetic.main.fragment_weather.*
import org.greenrobot.eventbus.EventBus

/**
 * Function:
 * Author: wonderful on 2020/1/14 9:19
 */

class ChooseAreaFragment(var isDrawerLayout: Boolean = true) :
    BaseBackFragment<ChooseAreaViewModel, ChooseAreaBinding>() {

    private lateinit var adapter: ArrayAdapter<String>

    private fun observe() {
        viewModel.currentLevel.observe(this, Observer { level ->
            when (level) {
                LEVEL_PROVINCE -> {
                    titleText.text = "中国"
                    backButton.visibility = View.GONE
                }
                LEVEL_CITY -> {
                    titleText.text = viewModel.selectedProvince?.provinceName
                    backButton.visibility = View.VISIBLE
                }
                LEVEL_COUNTY -> {
                    titleText.text = viewModel.selectedCity?.cityName
                    backButton.visibility = View.VISIBLE
                }
            }
        })

        viewModel.dataChanged.observe(this, Observer {
            adapter.notifyDataSetChanged()
            listView.setSelection(0)
            dismissProgressDialog()
        })

        viewModel.isLoading.observe(this, Observer { isLoading ->
            if (isLoading) showProgressDialog()
            else dismissProgressDialog()
        })

        viewModel.areaSelected.observe(this, Observer { selected ->
            if (selected && viewModel.selectedCounty != null) {
                if (isDrawerLayout) {
                    val weatherFragment = parentFragment as WeatherFragment
                    weatherFragment.drawerLayout.closeDrawers()
                    weatherFragment.viewModel.weatherId = viewModel.selectedCounty!!.weatherId
                    weatherFragment.viewModel.refreshWeather()
                } else {
                    // refresh weather
                    EventBus.getDefault()
                        .post(RefreshWeatherEvent(viewModel.selectedCounty!!.weatherId))
                    pop()
                }
                viewModel.areaSelected.value = false
            }
        })

        if (viewModel.dataList.isEmpty()) {
            viewModel.getProvinces()
        }
    }

    companion object {
        const val LEVEL_PROVINCE = 0
        const val LEVEL_CITY = 1
        const val LEVEL_COUNTY = 2
    }

    override fun getLayoutId(): Int = R.layout.choose_area

    override fun getModelFactory(): ViewModelProvider.NewInstanceFactory =
        InjectorUtil.getChooseAreaModelFactory()

    override fun getViewModel(): Class<ChooseAreaViewModel> = ChooseAreaViewModel::class.java

    override fun bindView(bundle: Bundle?) {
        binding.viewModel = viewModel
        adapter = ChooseAreaAdapter(context!!, R.layout.simple_item, viewModel.dataList)
        listView.adapter = adapter
        observe()
    }
}