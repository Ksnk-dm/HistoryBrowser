package com.example.data.sensor.browser

import android.annotation.SuppressLint
import android.content.Context
import android.view.accessibility.AccessibilityEvent
import com.example.domain.local.LocalRepository
import com.example.domain.model.local.BrowserHistory
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
           if (it.text.isNotEmpty()) saveBrowserHistory(it.text.toString(), BrowserHistory.Browser.Samsung)
        }
    }
}