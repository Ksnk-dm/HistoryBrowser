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

    override fun getPackageName(): String = PACKAGE_NAME

    @SuppressLint("NewApi")
    override fun onAccessibilityEvent(accessibilityEvent: Any) {
        val event = accessibilityEvent as AccessibilityEvent
        val nodeInfo = event.source
        nodeInfo?.findAccessibilityNodeInfosByViewId(VIEW_ID)?.firstOrNull()?.let {
          if (!it.isFocused) saveBrowserHistory(it.text.toString(), BrowserHistory.Browser.Chrome)
        }
    }

    companion object {
        private const val PACKAGE_NAME = "com.android.chrome"
        private const val VIEW_ID = "com.android.chrome:id/url_bar"
    }
}