package com.deepak.apod.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.deepak.apod.data.local.db.dao.ApodDao
import com.deepak.apod.data.local.db.entity.ApodEntity


@Database(
    entities = [ApodEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ApodDatabase : RoomDatabase() {
    abstract fun ApodDao(): ApodDao
}