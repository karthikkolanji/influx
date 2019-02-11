package com.startedup.base.db.typeConverters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.startedup.base.model.influx.FnblistItem
import com.startedup.base.model.influx.FoodListItem
import com.startedup.base.model.influx.SubitemsItem


class FoodListConverters {

        @TypeConverter
        fun listToJson(value: List<FoodListItem>?): String {

            return Gson().toJson(value)
        }

        @TypeConverter
        fun jsonToList(value: String): List<FoodListItem>? {

            val objects = Gson().fromJson(value, Array<FoodListItem>::class.java) as Array<FoodListItem>
            return objects.toList()
        }

}