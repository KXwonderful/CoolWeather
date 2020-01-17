package com.wdf.coolweather.common.base.activity

import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.wdf.coolweather.R
import com.zyao89.view.zloading.ZLoadingDialog
import com.zyao89.view.zloading.Z_TYPE
import me.yokeyword.fragmentation.SupportActivity

/**
 * Function: base activity
 * Author: wonderful on 2020/1/16 15:30
 */

abstract class BaseActivity<VM : ViewModel, DB : ViewDataBinding> : SupportActivity() {

    lateinit var viewModel: VM

    lateinit var binding: DB

    private var pDialog: ZLoadingDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, getLayoutId())

        viewModel = ViewModelProviders.of(this).get(getViewModel())

        initSth()
        initProgressDialog()
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): Class<VM>

    // init sth
    private fun initSth() {

        // set status bar
        val decorView = window.decorView
        decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor = Color.TRANSPARENT

        // set orientation
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        // set soft input
        window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
                    or WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN
        )
    }

    /**
     * init progress dialog
     */
    private fun initProgressDialog() {
        if (pDialog == null) {
            pDialog = ZLoadingDialog(this)
            pDialog!!.setLoadingBuilder(Z_TYPE.INFECTION_BALL)
                .setLoadingColor(R.color.colorAccent) //ic_editor_color
                .setHintText(getString(R.string.loading_text))
                .setHintTextColor(Color.GRAY) // text ic_editor_color
                .setCanceledOnTouchOutside(false)
                .setCancelable(false)
        }
    }

    /**
     * show dialog
     */
    protected fun showProgressDialog() {
        pDialog?.show()
    }

    /**
     * hide dialog
     */
    protected fun dismissProgressDialog() {
        pDialog?.dismiss()
    }
}