package com.startedup.base.db.typeConverters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.startedup.base.model.influx.FnblistItem
import com.startedup.base.model.influx.FoodListItem
import com.startedup.base.model.influx.SubitemsItem


class FnbListtConverters {

        @TypeConverter
        fun listToJson(value: List<FnblistItem>?): String {

            return Gson().toJson(value)
        }

        @TypeConverter
        fun jsonToList(value: String): List<FnblistItem>? {

            val objects = Gson().fromJson(value, Array<FnblistItem>::class.java) as Array<FnblistItem>
            return objects.toList()
        }

}