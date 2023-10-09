package com.helloworld.helpers

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import com.facebook.react.ReactApplication
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactRootView

val Activity.rootView: ViewGroup
    get() = window.decorView.findViewById(android.R.id.content)

val Activity.reactInstanceManager: ReactInstanceManager
    get() = (application as ReactApplication).reactNativeHost.reactInstanceManager

fun ReactInstanceManager.initRootView(
    componentName: String,
    params: Bundle?,
): ReactRootView? = if (currentReactContext != null) {
    ReactRootView(currentReactContext).apply {
        startReactApplication(this@initRootView, componentName, params)
    }
} else {
    Log.e("ReactExt", "Current react context is null.")
    null
}