package com.startedup.base.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.startedup.base.model.influx.Food

@Dao
interface InfluxDao {

    @Insert
    fun insert(food: Food)

    @Query("SELECT * FROM food")
    fun getAll(): LiveData<Food>
}