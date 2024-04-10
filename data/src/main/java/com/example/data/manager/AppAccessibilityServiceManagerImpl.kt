package com.example.data.manager

import android.annotation.SuppressLint
import android.view.accessibility.AccessibilityEvent
import com.example.domain.manager.AppAccessibilityServiceManager
import com.example.domain.sensor.accessibility.browsers.ChromeBrowserAccessibilitySensor
import com.example.domain.sensor.accessibility.browsers.MozillaBrowserAccessibilitySensor
import com.example.domain.sensor.accessibility.browsers.SamsungBrowserAccessibilitySensor
import javax.inject.Inject

class AppAccessibilityServiceManagerImpl @Inject constructor(
    private var chromeBrowserAccessibilitySensor: ChromeBrowserAccessibilitySensor,
    private var samsungBrowserAccessibilitySensor: SamsungBrowserAccessibilitySensor,
    private var mozillaBrowserAccessibilitySensor: MozillaBrowserAccessibilitySensor
) : AppAccessibilityServiceManager {
    @SuppressLint("NewApi")
    override fun onAccessibilityEvent(accessibilityEvent: Any) {
        val event = accessibilityEvent as AccessibilityEvent

        event.source?.let {

            when (it.packageName) {
                chromeBrowserAccessibilitySensor.getPackageName() -> chromeBrowserAccessibilitySensor.onAccessibilityEvent(event)
                samsungBrowserAccessibilitySensor.getPackageName() -> samsungBrowserAccessibilitySensor.onAccessibilityEvent(event)
                mozillaBrowserAccessibilitySensor.getPackageName() -> mozillaBrowserAccessibilitySensor.onAccessibilityEvent(event)
            }
        }
    }
}