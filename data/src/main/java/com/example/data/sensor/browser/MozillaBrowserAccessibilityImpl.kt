package com.example.data.sensor.browser

import android.annotation.SuppressLint
import android.view.accessibility.AccessibilityEvent
import com.example.domain.local.LocalRepository
import com.example.domain.model.local.BrowserHistory
import com.example.domain.sensor.accessibility.browsers.MozillaBrowserAccessibilitySensor
import javax.inject.Inject

class MozillaBrowserAccessibilityImpl @Inject constructor(private val localRepository: LocalRepository) : BaseBrowserAccessibilitySensorImpl(localRepository), MozillaBrowserAccessibilitySensor {
    override fun getPackageName(): String = PACKAGE_NAME

    @SuppressLint("NewApi")
    override fun onAccessibilityEvent(accessibilityEvent: Any) {
        val event = accessibilityEvent as AccessibilityEvent
        val nodeInfo = event.source
        nodeInfo?.findAccessibilityNodeInfosByViewId(VIEW_ID)?.firstOrNull()?.let {
            saveBrowserHistory(it.text.toString(), BrowserHistory.Browser.Mozilla)
        }
    }

    companion object {
        private const val PACKAGE_NAME = "org.mozilla.firefox"
        private const val VIEW_ID = "org.mozilla.firefox:id/mozac_browser_toolbar_url_view"
    }
}