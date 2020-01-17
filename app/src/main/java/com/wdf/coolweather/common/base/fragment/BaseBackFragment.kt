package com.wdf.coolweather.common.base.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.wdf.coolweather.R
import com.zyao89.view.zloading.ZLoadingDialog
import com.zyao89.view.zloading.Z_TYPE
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment

/**
 * Function: base fragment with back
 * Author: wonderful on 2020/1/16 11:45
 */

abstract class BaseBackFragment<VM : ViewModel, DB : ViewDataBinding> : SwipeBackFragment() {

    lateinit var viewModel: VM

    lateinit var binding: DB

    lateinit var rootView: View

    private var pDialog: ZLoadingDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, getModelFactory()).get(getViewModel())
        initBundle()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(getLayoutId(), container, false)
        binding = DataBindingUtil.bind(rootView)!!
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bindView(savedInstanceState)
        initProgressDialog()
    }

    // init bundle
    private fun initBundle() {}

    // get layout id
    @LayoutRes
    abstract fun getLayoutId(): Int

    // get model factory
    abstract fun getModelFactory(): ViewModelProvider.NewInstanceFactory

    // get viewModel
    abstract fun getViewModel(): Class<VM>

    // bind view
    abstract fun bindView(bundle: Bundle?)

    // back click
    protected fun back() {
        _mActivity.onBackPressed()
    }

    /**
     * init progress dialog
     */
    private fun initProgressDialog() {
        if (pDialog == null) {
            pDialog = ZLoadingDialog(_mActivity)
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