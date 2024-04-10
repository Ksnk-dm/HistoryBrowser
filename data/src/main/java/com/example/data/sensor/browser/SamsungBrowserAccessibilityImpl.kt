package com.example.data.sensor.browser

import android.annotation.SuppressLint
import android.view.accessibility.AccessibilityEvent
import com.example.domain.local.LocalRepository
import com.example.domain.model.local.BrowserHistory
import com.example.domain.sensor.accessibility.browsers.SamsungBrowserAccessibilitySensor
import javax.inject.Inject

class SamsungBrowserAccessibilityImpl @Inject constructor(private val localRepository: LocalRepository) : BaseBrowserAccessibilitySensorImpl(localRepository),
    SamsungBrowserAccessibilitySensor {

    override fun getPackageName(): String = PACKAGE_NAME

    @SuppressLint("NewApi")
    override fun onAccessibilityEvent(accessibilityEvent: Any) {
        val event = accessibilityEvent as AccessibilityEvent
        val nodeInfo = event.source
        nodeInfo?.findAccessibilityNodeInfosByViewId(VIEW_ID)?.firstOrNull()?.let {
           if (it.text.isNotEmpty()) saveBrowserHistory(it.text.toString(), BrowserHistory.Browser.Samsung)
        }
    }

    companion object {
        private const val PACKAGE_NAME = "com.sec.android.app.sbrowser"
        private const val VIEW_ID = "com.sec.android.app.sbrowser:id/location_bar_edit_text"
    }
}