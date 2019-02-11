package com.startedup.base.model.influx

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.startedup.base.db.typeConverters.FnbListtConverters
import com.startedup.base.db.typeConverters.FoodListConverters

@Entity(tableName = "food_list_item")
@TypeConverters(FnbListtConverters::class)
data class FoodListItem(
        @PrimaryKey val id:Int,
        @ColumnInfo(name = "fnb_list")var fnblist: List<FnblistItem?>? = null,
        @ColumnInfo(name = "tab_name")var TabName: String? = null
)
