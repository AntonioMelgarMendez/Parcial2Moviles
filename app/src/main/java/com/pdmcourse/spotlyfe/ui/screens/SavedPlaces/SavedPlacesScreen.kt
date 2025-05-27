package com.pdmcourse.spotlyfe.ui.screens.SavedPlaces

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.navOptions
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.pdmcourse.spotlyfe.ui.layout.CustomFloatingButton
import com.pdmcourse.spotlyfe.ui.layout.CustomTopBar
import com.pdmcourse.spotlyfe.ui.navigation.NewPlaceScreenNavigation

@Composable
fun SavedPlacesScreen(
  navController: NavController,
  viewModel: SavedPlacesViewModel
) {
  val places by viewModel.places.collectAsState()
  val cameraPositionState = rememberCameraPositionState {
    position = if (places.isNotEmpty()) {
      CameraPosition.fromLatLngZoom(
        LatLng(places[0].latitude, places[0].longitude), 16f
      )
    } else {
      CameraPosition.fromLatLngZoom(LatLng(0.0, 0.0), 1f)
    }
  }
  val uiSettings = MapUiSettings(zoomControlsEnabled = false)
  val properties = MapProperties(mapType = MapType.HYBRID)

  Scaffold(
    topBar = { CustomTopBar() },
    floatingActionButton = {
      CustomFloatingButton(onClick = {
        navController.navigate(
          NewPlaceScreenNavigation,
          navOptions {
            launchSingleTop = true
            restoreState = true
          }
        )
      })
    }
  ) { innerPadding ->
    Column(modifier = Modifier.padding(innerPadding)) {
      GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = properties,
        uiSettings = uiSettings
      ) {
        places.forEach { place ->
          Marker(
            state = MarkerState(position = LatLng(place.latitude, place.longitude)),
            title = place.name,
            snippet = place.remark
          )
        }
      }
    }
  }
}