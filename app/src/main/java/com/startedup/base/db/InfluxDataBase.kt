package com.startedup.base.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.startedup.base.db.typeConverters.FnbListtConverters
import com.startedup.base.db.typeConverters.FoodListConverters
import com.startedup.base.model.influx.*
import com.startedup.base.db.typeConverters.SubItemListConverters

@Database(entities = [Food::class, FoodListItem::class, Status::class, SubitemsItem::class, FnblistItem::class],
        version = 1)


abstract class InfluxDataBase : RoomDatabase() {

    abstract fun influxDao(): InfluxDao
}