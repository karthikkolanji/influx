package com.startedup.base.db.typeConverters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.startedup.base.model.influx.FnblistItem
import com.startedup.base.model.influx.FoodListItem
import com.startedup.base.model.influx.SubitemsItem


class SubItemListConverters {

    @TypeConverter
    fun listToJson(value: List<SubitemsItem>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<SubitemsItem>? {

        val objects = Gson().fromJson(value, Array<SubitemsItem>::class.java) as Array<SubitemsItem>
        return objects.toList()
    }

}