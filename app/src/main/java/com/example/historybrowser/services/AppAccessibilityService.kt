package com.example.historybrowser.services

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import com.example.domain.manager.AppAccessibilityServiceManager
import dagger.android.AndroidInjection
import javax.inject.Inject

class AppAccessibilityService : AccessibilityService() {

    @Inject
    lateinit var appAccessibilityServiceManager: AppAccessibilityServiceManager

    override fun onCreate() {
        super.onCreate()
        AndroidInjection.inject(this)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event?.let {
            when (it.eventType) {
                AccessibilityEvent.TYPE_VIEW_CLICKED,
                AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED,
                AccessibilityEvent.TYPE_VIEW_SCROLLED,
                AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED -> appAccessibilityServiceManager.onAccessibilityEvent(event)

                else -> {}
            }
        }
    }

    override fun onInterrupt() {}
}