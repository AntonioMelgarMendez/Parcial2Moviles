package com.pdmcourse.spotlyfe.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "places")
data class PlaceEntity (
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,
  var name: String,
  var description: String,
  var latitude: Double,
  var longitude: Double,
  val remark: String,
)