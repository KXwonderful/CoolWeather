package com.wdf.coolweather.ui

import android.os.Bundle
import com.wdf.coolweather.R
import com.wdf.coolweather.common.base.activity.SimpleActivity
import com.wdf.coolweather.event.ToFragmentEvent
import com.wdf.coolweather.ui.weather.WeatherFragment
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : SimpleActivity() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView(bundle: Bundle?) {

        EventBus.getDefault().register(this)

        if (bundle == null) {
            loadRootFragment(R.id.container, WeatherFragment())
        }
    }

    /**
     * start other brother Fragment
     */
    @Subscribe
    fun switchFragment(event: ToFragmentEvent) {
        start(event.targetFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}
