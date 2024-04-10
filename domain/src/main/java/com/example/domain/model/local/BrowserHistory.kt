package com.example.domain.model.local

data class BrowserHistory (
    var url: String,
    var request: String,
    var date: Long,
    var browser: Browser
) {
    var id: Long = 0
        enum class Browser() {
            Chrome,
            Samsung,
            Mozilla
        }
}