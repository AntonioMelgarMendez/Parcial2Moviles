package com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.NewPlaceScreen

import com.pdmcourse.spotlyfe.data.database.entities.PlaceDao
import com.pdmcourse.spotlyfe.data.database.entities.PlaceEntity
import com.pdmcourse.spotlyfe.data.model.Place

fun PlaceRepository(
    placeDao: PlaceDao
) {
    suspend fun addPlace(place: Place) {
        val placeEntity = PlaceEntity(
            name = place.name,
            remark = place.remark,
            latitude = place.latitude,
            longitude = place.longitude,
            description = ""
        )
        placeDao.insertPlace(placeEntity)
    }

    suspend fun getAllPlaces(): List<PlaceEntity> {
        return placeDao.getAllPlaces()
    }

    suspend fun updatePlace(place: PlaceEntity) {
        placeDao.updatePlace(place)
    }

    suspend fun deletePlace(id: Int) {
        placeDao.deletePlace(id)
    }

    suspend fun getPlaceById(id: Int): PlaceEntity? {
        return placeDao.getPlaceById(id)
    }
}