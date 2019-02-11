package com.startedup.base.model.influx

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.startedup.base.db.typeConverters.FnbListtConverters
import com.startedup.base.db.typeConverters.FoodListConverters

@Entity (tableName = "food")
@TypeConverters(FoodListConverters::class)
data class Food(
        @PrimaryKey val id:Int,
        @ColumnInfo(name = "currency")var Currency: String? = null,
        @ColumnInfo(name = "food_list") var FoodList: List<FoodListItem?>? = null
)
