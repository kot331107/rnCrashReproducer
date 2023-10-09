package com.helloworld.hero

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager

class HeroPackage : ReactPackage {
    private var viewManagersList: List<ViewManager<*, *>> = ArrayList()
    private var nativeModulesList: List<NativeModule> = ArrayList()
    private var reactContext: ReactApplicationContext? = null

    override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
        return getNativeModulesList(reactContext)
    }

    override fun createViewManagers(reactContext: ReactApplicationContext):
            List<ViewManager<*, *>> = viewManagersList

    private fun getNativeModulesList(reactContext: ReactApplicationContext):
            List<NativeModule> {
        if (reactContext != this.reactContext || nativeModulesList.isEmpty()) {
            this.reactContext = reactContext
            nativeModulesList = listOf(
                HeroService(reactContext)
            )
        }
        return nativeModulesList
    }
}