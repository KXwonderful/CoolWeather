package com.wdf.coolweather.ui.weather

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import com.wdf.coolweather.R
import com.wdf.coolweather.common.base.fragment.BaseMainFragment
import com.wdf.coolweather.databinding.FragmentWeatherBinding
import com.wdf.coolweather.event.RefreshWeatherEvent
import com.wdf.coolweather.ui.area.ChooseAreaFragment
import com.wdf.coolweather.util.InjectorUtil
import kotlinx.android.synthetic.main.fragment_weather.*
import kotlinx.android.synthetic.main.title.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

/**
 * Function: weather fragment
 * Author: wonderful on 2020/1/16 16:30
 */

class WeatherFragment : BaseMainFragment<WeatherViewModel, FragmentWeatherBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_weather

    override fun getModelFactory(): ViewModelProvider.NewInstanceFactory =
        InjectorUtil.getWeatherModelFactory()

    override fun getViewModel(): Class<WeatherViewModel> = WeatherViewModel::class.java

    override fun bindView(bundle: Bundle?) {

        EventBus.getDefault().register(this)

        binding.viewModel = viewModel
        binding.resId = R.color.colorPrimary
        binding.lifecycleOwner = this

        if (!viewModel.isWeatherCached()) {
            start(ChooseAreaFragment(false))
            return
        }

        viewModel.weatherId = viewModel.getCachedWeather().basic.weatherId

        navButton.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        viewModel.getWeather()
    }

    /**
     * refresh
     */
    @Subscribe
    fun refreshWeather(event: RefreshWeatherEvent) {
        viewModel.weatherId = event.weatherId
        viewModel.refreshWeather()
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    /*companion object {
        fun newInstance(): WeatherFragment {
            val args = Bundle()
            val fragment = WeatherFragment()
            fragment.arguments = args
            return fragment
        }
    }*/

}