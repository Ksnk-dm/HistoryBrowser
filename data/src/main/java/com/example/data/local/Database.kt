package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.db.dao.BrowserHistoryDao
import com.example.data.local.db.model.BrowserHistoryEntity

@Database(entities = [BrowserHistoryEntity::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract val browserHistoryDao: BrowserHistoryDao
}