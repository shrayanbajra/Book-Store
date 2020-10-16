package com.example.bookstore.utils

import android.view.View

object DisplayMetricsUtils {

    fun getPixelValue(dps: Float, view: View): Float {
        val scale = view.context.resources.displayMetrics.density
        return (dps * scale + 0.5f)
    }

}