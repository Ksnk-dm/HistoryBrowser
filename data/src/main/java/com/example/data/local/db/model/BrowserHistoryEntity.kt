package com.example.data.local.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BrowserHistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var url: String,
    var date: Long,
    var browser: String
)
