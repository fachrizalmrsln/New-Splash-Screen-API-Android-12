package com.fachrizalmrsln.newsplashscreenapi_android12

import android.app.Activity
import android.view.View
import android.view.ViewTreeObserver

fun Activity.initiateSplashScreen() {
    var splashReady = true
    val content: View = findViewById(android.R.id.content)
    content.viewTreeObserver.addOnPreDrawListener(
        object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                // Check if the initial data is ready.
                return if (splashReady) {
                    // The content is ready; start drawing.
                    content.viewTreeObserver.removeOnPreDrawListener(this)
                    true
                } else {
                    splashReady = false
                    // The content is not ready; suspend.
                    false
                }
            }
        }
    )
}