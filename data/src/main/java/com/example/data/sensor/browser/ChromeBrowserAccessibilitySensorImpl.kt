package com.example.data.sensor.browser

import android.annotation.SuppressLint
import android.content.Context
import android.view.accessibility.AccessibilityEvent
import com.example.domain.local.LocalRepository
import com.example.domain.model.local.BrowserHistory
import com.example.domain.sensor.accessibility.browsers.ChromeBrowserAccessibilitySensor
import javax.inject.Inject

class ChromeBrowserAccessibilitySensorImpl @Inject constructor(context: Context, private val localRepository: LocalRepository,) : BaseBrowserAccessibilitySensorImpl(localRepository),
    ChromeBrowserAccessibilitySensor {

    override fun getPackageName(): String {
        return "com.android.chrome"
    }

    @SuppressLint("NewApi")
    override fun onAccessibilityEvent(accessibilityEvent: Any) {
        val event = accessibilityEvent as AccessibilityEvent
        val nodeInfo = event.source
        nodeInfo?.findAccessibilityNodeInfosByViewId("com.android.chrome:id/url_bar")?.firstOrNull()?.let {
          if (!it.isFocused) saveBrowserHistory(it.text.toString(), BrowserHistory.Browser.Chrome)
        }
    }
}