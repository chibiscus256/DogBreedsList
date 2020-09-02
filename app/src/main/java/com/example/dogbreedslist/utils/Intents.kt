package com.example.dogbreedslist.utils

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.core.app.ShareCompat

/**
 * Android system intents
 */

fun intentShareText(activity: Activity, text: String) {
    val shareIntent = ShareCompat.IntentBuilder.from(activity)
            .setText(text)
            .setType("text/plain")
            .createChooserIntent()
            .addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)

    activity.startActivity(shareIntent)
}

fun intentOpenWebsite(activity: Activity, url: String) {
    val openURL = Intent(Intent.ACTION_VIEW)
    openURL.data = Uri.parse(url)
    activity.startActivity(openURL)
}
