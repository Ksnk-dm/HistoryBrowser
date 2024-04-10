package com.example.data.sensor.browser

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import com.example.domain.local.LocalRepository
import com.example.domain.sensor.accessibility.browsers.ChromeBrowserAccessibilitySensor
import com.example.domain.sensor.accessibility.browsers.SamsungBrowserAccessibilitySensor
import javax.inject.Inject

class SamsungBrowserAccessibilityImpl @Inject constructor(context: Context, private val localRepository: LocalRepository) : BaseBrowserAccessibilitySensorImpl(localRepository),
    SamsungBrowserAccessibilitySensor {
    override fun getPackageName(): String {
        return "com.sec.android.app.sbrowser"
    }

    @SuppressLint("NewApi")
    override fun onAccessibilityEvent(accessibilityEvent: Any) {
        val event = accessibilityEvent as AccessibilityEvent
        val nodeInfo = event.source
        nodeInfo?.findAccessibilityNodeInfosByViewId("com.sec.android.app.sbrowser:id/location_bar_edit_text")?.firstOrNull()?.let {
            Log.d("MESSAGE::: ", it.text.toString())
        }
    }
}