package com.example.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.local.db.model.BrowserHistoryEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface BrowserHistoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(list: List<BrowserHistoryEntity>): Completable

    @Update
    fun update(item: BrowserHistoryEntity): Completable

    @Query("SELECT * FROM BrowserHistoryEntity")
    fun selectBrowserBookmarks(): Flowable<List<BrowserHistoryEntity>>
}