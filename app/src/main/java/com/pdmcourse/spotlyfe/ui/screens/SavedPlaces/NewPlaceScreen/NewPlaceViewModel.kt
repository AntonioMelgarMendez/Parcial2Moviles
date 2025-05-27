package com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.NewPlaceScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdmcourse.spotlyfe.data.database.PlaceRepository
import com.pdmcourse.spotlyfe.data.model.Place
import kotlinx.coroutines.launch

class NewPlaceViewModel(
    private val repository: PlaceRepository
) : ViewModel() {
    fun insertPlace(place: Place) {
        viewModelScope.launch {
            repository.insertPlace(place)
        }
    }
}