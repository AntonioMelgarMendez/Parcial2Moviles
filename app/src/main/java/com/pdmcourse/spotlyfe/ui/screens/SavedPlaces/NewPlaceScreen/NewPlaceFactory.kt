package com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.NewPlaceScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pdmcourse.spotlyfe.data.database.PlaceRepository

class NewPlaceViewModelFactory(
    private val repository: PlaceRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewPlaceViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NewPlaceViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}