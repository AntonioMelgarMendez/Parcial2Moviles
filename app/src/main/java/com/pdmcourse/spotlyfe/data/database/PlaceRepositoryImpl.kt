package com.pdmcourse.spotlyfe.data.database

import android.content.Context
import com.pdmcourse.spotlyfe.data.database.entities.PlaceEntity
import com.pdmcourse.spotlyfe.data.model.Place
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PlaceRepositoryImpl(context: Context) : PlaceRepository {

    private val placeDao = AppDatabase.getDatabase(context).placeDao()

    override suspend fun insertPlace(place: Place) {
        placeDao.insertPlace(place.toEntity())
    }

    override fun getAllPlaces(): Flow<List<Place>> {
        return placeDao.getAllPlaces().map { list -> list.map { it.toModel() } }
    }

    override suspend fun deletePlace(place: Place) {

    }

    override suspend fun updatePlace(place: Place) {

    }
}

fun Place.toEntity() = PlaceEntity(
    name = this.name,
    latitude = this.latitude,
    longitude = this.longitude,
    description ="",
    remark = this.remark
)

fun PlaceEntity.toModel() = Place(
    name = this.name,
    latitude = this.latitude,
    longitude = this.longitude,
    remark = this.remark
)