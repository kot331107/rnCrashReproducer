package com.helloworld.hero

import android.content.MutableContextWrapper
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.facebook.react.ReactRootView
import com.helloworld.helpers.initRootView
import com.helloworld.helpers.reactInstanceManager


class OverlayFragment: Fragment() {
    companion object {
        fun newInstance(): Fragment {
            // return Builder().setComponentName("Hero.HeroScreen").setFabricEnabled(false).build()
            return OverlayFragment()
        }
    }

    private val draggableView: ReactRootView? by lazy {
        activity?.reactInstanceManager?.initRootView("Hero.HeroScreen", Bundle())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = context?.run {
        FrameLayout(this).also { viewGroup ->
            viewGroup.layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (view as? ViewGroup)?.addView(draggableView)
    }
}