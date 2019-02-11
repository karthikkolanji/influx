package com.startedup.base.model.influx

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "status")
data class Status(
		@PrimaryKey var id_:Int,
		@ColumnInfo(name = "description") var description: String? = null,
		@ColumnInfo(name = "status_id")var id: String? = null
)
