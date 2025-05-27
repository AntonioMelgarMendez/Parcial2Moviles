package com.pdmcourse.spotlyfe.data

import com.pdmcourse.spotlyfe.data.database.AppDatabase
import com.pdmcourse.spotlyfe.data.database.PlaceRepository


class AppContainer(private val database: AppDatabase) {

    val placeDao = database.placeDao()

}