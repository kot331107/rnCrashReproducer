package com.helloworld.hero

import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.module.annotations.ReactModule
import com.helloworld.R
import com.helloworld.helpers.rootView

private const val FRAGMENT_TAG_NAME = "DockableHeroFragment"
private const val LOG_TAG = "HeroService"

@Suppress("MemberVisibilityCanPrivate", "unused")
@ReactModule(name = "HeroService")
class HeroService(
    reactContext: ReactApplicationContext,
) : ReactContextBaseJavaModule(reactContext) {

    private var isModalPresented: Boolean = false

    override fun getName(): String {
        return "HeroService"
    }

    @ReactMethod
    fun showModal() = presentFragment()

    private fun presentFragment() {
        if (isModalPresented) {
            return
        }

        (reactApplicationContext.currentActivity as? FragmentActivity)?.run {
            with(rootView.findViewById<ViewGroup>(R.id.fragment_container)?.layoutParams as FrameLayout.LayoutParams) {
                height = resources.displayMetrics.heightPixels / 4
                width = ViewGroup.LayoutParams.MATCH_PARENT
                gravity = Gravity.BOTTOM
            }
            with(supportFragmentManager) {
                if (findFragmentByTag(FRAGMENT_TAG_NAME) == null) {
                    runOnUiThread { // lifecycle observer requires it to run on the main thread
                        beginTransaction()
                            .add(
                                R.id.fragment_container,
                                OverlayFragment.newInstance(),
                                FRAGMENT_TAG_NAME,
                            )
                            .commitAllowingStateLoss()
                    }
                    isModalPresented = true
                }
            }
        } ?: Log.w(LOG_TAG, "Can't add fragment to the current activity")
    }
}