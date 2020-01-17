package com.wdf.coolweather.common.util

import android.annotation.SuppressLint
import android.widget.Toast
import com.wdf.coolweather.common.app.MyApplication

/**
 * Function: toast util
 * Author: wonderful on 2020/1/16 11:20
 */

@SuppressLint("ShowToast")
object ToastUtils {

    private var toast: Toast? = null

    /**
     * show short Toast
     */
    fun show(message: String?) {
        if (null == toast) {
            toast = Toast.makeText(MyApplication.context, message, Toast.LENGTH_SHORT)
            // toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast!!.setText(message)
        }
        toast!!.show()
    }

    /**
     * show short Toast with string id
     */
    fun show(resId: Int) {
        show(MyApplication.context.getString(resId))
    }

    /**
     * show long Toast
     */
    @JvmStatic
    fun showLong(message: String?) {
        if (null == toast) {
            toast = Toast.makeText(MyApplication.context, message, Toast.LENGTH_LONG)
        } else {
            toast!!.setText(message)
        }
        toast!!.show()
    }

    /**
     * show long Toast with string id
     */
    fun showLong(resId: Int) {
        showLong(MyApplication.context.getString(resId))
    }

    /**
     * show custom Toast
     *
     * @param message
     * @param duration
     */
    @JvmStatic
    fun show(message: String?, duration: Int) {
        if (null == toast) {
            toast = Toast.makeText(MyApplication.context, message, duration)
        } else {
            toast!!.setText(message)
        }
        toast!!.show()
    }

    /**
     * show custom Toast with string id
     *
     * @param resId
     * @param duration
     */
    fun show(resId: Int, duration: Int) {
        show(MyApplication.context.getString(resId), duration)
    }

    /**
     * Hide the toast, if any.
     */
    fun hideToast() {
        if (null != toast) {
            toast!!.cancel()
        }
    }
}