package com.pdmcourse.spotlyfe.data

import android.content.Context
import com.pdmcourse.spotlyfe.data.database.PlaceRepository
import com.pdmcourse.spotlyfe.data.database.PlaceRepositoryImpl

class AppProvider(context: Context) {
  val placeRepository: PlaceRepository = PlaceRepositoryImpl(context)
}