package com.startedup.base.model.influx

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "sub_items_list")
data class SubitemsItem(
        @PrimaryKey var id:Int,
        @ColumnInfo(name = "sub_item_price") var SubitemPrice: String? = null,
        @ColumnInfo(name = "vista_sub_food_item_id") var VistaSubFoodItemId: String? = null,
        @ColumnInfo(name = "price_in_cents") var PriceInCents: String? = null,
        @ColumnInfo(name = "vista_parent_food_item_id") var VistaParentFoodItemId: String? = null,
        @ColumnInfo(name = "name") var Name: String? = null
)
