package com.pdmcourse.spotlyfe.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pdmcourse.spotlyfe.data.database.PlaceRepository
import com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.NewPlaceScreen.NewPlaceScreen
import com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.NewPlaceScreen.NewPlaceViewModel
import com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.NewPlaceScreen.NewPlaceViewModelFactory
import com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.SavedPlacesScreen
import com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.SavedPlacesViewModel

@Composable
fun MainNavigation(navController: NavHostController, repository: PlaceRepository) {
  NavHost(navController = navController, startDestination = SavedPlacesScreenNavigation) {
    composable<SavedPlacesScreenNavigation> {
      val viewModel: SavedPlacesViewModel = viewModel(
        factory = object : androidx.lifecycle.ViewModelProvider.Factory {
          override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return SavedPlacesViewModel(repository) as T
          }
        }
      )
      SavedPlacesScreen(navController = navController, viewModel = viewModel)
    }
    composable<NewPlaceScreenNavigation> {
      val viewModel: NewPlaceViewModel = viewModel(
        factory = NewPlaceViewModelFactory(repository)
      )
      NewPlaceScreen(navController = navController, viewModel = viewModel)
    }
  }
}