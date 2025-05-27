package com.pdmcourse.spotlyfe.ui.screens.SavedPlaces

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdmcourse.spotlyfe.data.database.PlaceRepository
import com.pdmcourse.spotlyfe.data.model.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SavedPlacesViewModel(private val repository: PlaceRepository) : ViewModel() {
    private val _places = MutableStateFlow<List<Place>>(emptyList())
    val places: StateFlow<List<Place>> = _places.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllPlaces().collect { list ->
                _places.value = list
            }
        }
    }
}