package com.startedup.base.model.influx

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.startedup.base.db.typeConverters.FnbListtConverters
import com.startedup.base.db.typeConverters.FoodListConverters
import com.startedup.base.db.typeConverters.SubItemListConverters


@Entity(tableName = "fnb_list_item")
@TypeConverters(SubItemListConverters::class)
data class FnblistItem(
        @PrimaryKey var id:Int,
        @ColumnInfo(name = "veg_class") var VegClass: String? = null,
        @ColumnInfo(name = "item_price") var ItemPrice: String? = null,
        @ColumnInfo(name = "image_url") var ImageUrl: String? = null,
        @ColumnInfo(name = "img_url") var ImgUrl: String? = null,
        @ColumnInfo(name = "name") var Name: String? = null,
        @ColumnInfo(name = "other_experience") var OtherExperience: String? = null,
        @ColumnInfo(name = "cinemaid") var Cinemaid: String? = null,
        @ColumnInfo(name = "price_in_cents") var PriceInCents: String? = null,
        @ColumnInfo(name = "sub_items") var subitems: List<SubitemsItem?>? = null,
        @ColumnInfo(name = "seven_star_experience") var SevenStarExperience: String? = null,
        @ColumnInfo(name = "tab_name") var TabName: String? = null,
        @ColumnInfo(name = "sub_item_count") var SubItemCount: Int? = null,
        @ColumnInfo(name = "vista_food_item_id") var VistaFoodItemId: String? = null
)
