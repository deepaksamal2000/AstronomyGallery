package com.deepak.apod.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deepak.apod.data.local.db.entity.ApodEntity

@Dao
interface ApodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPicture(apodEntity: ApodEntity)

    @Query("SELECT * FROM apod ")
    suspend fun getApodDetails(): ApodEntity
}