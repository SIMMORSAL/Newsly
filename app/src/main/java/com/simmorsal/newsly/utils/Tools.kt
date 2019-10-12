package com.simmorsal.newsly.utils

import android.content.Context
import android.content.Intent
import android.net.Uri


fun openLink(context: Context, url: String?) {
    url?.let {
        val u = if (!url.startsWith("http://") && !url.startsWith("https://"))
            "http://$url"
        else url

        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(u))
        context.startActivity(browserIntent)
    }
}