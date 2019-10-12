package com.simmorsal.newsly.utils

import android.content.Context
import android.content.res.Configuration


fun isPhonePortrait(context: Context): Boolean {
    val orientation = context.resources.configuration.orientation
    return orientation == Configuration.ORIENTATION_PORTRAIT
}