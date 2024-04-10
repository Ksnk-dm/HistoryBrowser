package com.example.domain.sensor.accessibility.browsers

import com.example.domain.sensor.accessibility.AccessibilitySensor

interface BrowserAccessibilitySensor : AccessibilitySensor {

    fun getPackageName(): String
}