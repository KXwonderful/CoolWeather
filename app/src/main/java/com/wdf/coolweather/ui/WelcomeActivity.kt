package com.wdf.coolweather.ui

import android.content.Intent
import android.os.Bundle
import com.wdf.coolweather.R
import com.wdf.coolweather.common.base.activity.SimpleActivity

class WelcomeActivity : SimpleActivity() {

    override fun getLayoutId(): Int = R.layout.activity_welcome

    override fun initView(bundle: Bundle?) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
