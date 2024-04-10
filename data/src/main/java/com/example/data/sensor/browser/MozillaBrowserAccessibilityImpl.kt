package com.example.data.sensor.browser

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import com.example.domain.local.LocalRepository
import com.example.domain.sensor.accessibility.browsers.ChromeBrowserAccessibilitySensor
import com.example.domain.sensor.accessibility.browsers.MozillaBrowserAccessibilitySensor
import javax.inject.Inject

class MozillaBrowserAccessibilityImpl @Inject constructor(context: Context, private val localRepository: LocalRepository) : BaseBrowserAccessibilitySensorImpl(localRepository), MozillaBrowserAccessibilitySensor {
    override fun getPackageName(): String {
        return "org.mozilla.firefox"
    }

    @SuppressLint("NewApi")
    override fun onAccessibilityEvent(accessibilityEvent: Any) {
        val event = accessibilityEvent as AccessibilityEvent
        val nodeInfo = event.source
        nodeInfo?.findAccessibilityNodeInfosByViewId("org.mozilla.firefox:id/mozac_browser_toolbar_url_view")?.firstOrNull()?.let {
            Log.d("MESSAGE::: ", it.text.toString())
        }
    }
}