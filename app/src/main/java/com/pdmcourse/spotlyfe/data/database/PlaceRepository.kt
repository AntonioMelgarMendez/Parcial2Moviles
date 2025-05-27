package com.pdmcourse.spotlyfe.data.database

import com.pdmcourse.spotlyfe.data.model.Place
import kotlinx.coroutines.flow.Flow

interface PlaceRepository {
    suspend fun insertPlace(place: Place)
    fun getAllPlaces(): Flow<List<Place>>
    suspend fun deletePlace(place: Place)
    suspend fun updatePlace(place: Place)
}