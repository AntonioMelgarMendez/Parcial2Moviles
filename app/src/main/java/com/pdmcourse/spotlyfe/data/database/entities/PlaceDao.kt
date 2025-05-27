package com.pdmcourse.spotlyfe.data.database.entities
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.pdmcourse.spotlyfe.data.model.Place

@Dao
interface PlaceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlace(place: PlaceEntity)

    @Query("SELECT * FROM places")
    suspend fun getAllPlaces(): List<PlaceEntity>

    @Update
    suspend fun updatePlace(place: PlaceEntity)

    @Query("DELETE FROM places WHERE id = :id")
    suspend fun deletePlace(id: Int)

    @Query("SELECT * FROM places WHERE id = :id")
    suspend fun getPlaceById(id: Int): PlaceEntity?
}