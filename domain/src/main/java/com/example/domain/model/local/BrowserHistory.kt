package com.example.domain.model.local

data class BrowserHistory (
    var url: String,
    var date: Long,
    var browser: String
) {
    var id: Long = 0
}