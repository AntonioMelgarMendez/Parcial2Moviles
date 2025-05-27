package com.pdmcourse.spotlyfe.ui.screens.SavedPlaces

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
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
import com.pdmcourse.spotlyfe.data.model.Place
import com.pdmcourse.spotlyfe.ui.components.ModalSavePlaces
import com.pdmcourse.spotlyfe.ui.layout.CustomFloatingButton
import com.pdmcourse.spotlyfe.ui.layout.CustomTopBar
import com.pdmcourse.spotlyfe.ui.navigation.NewPlaceScreenNavigation
import com.pdmcourse.spotlyfe.ui.navigation.SavedPlacesScreenNavigation

@Composable
fun SavedPlacesScreen(navController: NavController) {
  val UCA = Place(
    name = "Centro Monseñor Romero",
    remark = "Marker in Centro Monseñor Romero",
    latitude = 13.679024407659101,
    longitude = -89.23578718993471,
  )

  val cameraPositionState = rememberCameraPositionState {
    position = CameraPosition.fromLatLngZoom(LatLng(UCA.latitude, UCA.longitude), 16f)
  }

  var uiSettings by remember {
    mutableStateOf(MapUiSettings(zoomControlsEnabled = false))
  }
  var properties by remember {
    mutableStateOf(MapProperties(mapType = MapType.HYBRID))
  }

  Scaffold(
    topBar = { CustomTopBar() },
    floatingActionButton = { CustomFloatingButton(onClick = {
        navController.navigate(
            NewPlaceScreenNavigation,
            navOptions {
            launchSingleTop = true
            restoreState = true
            }
        )
    })}
  ) { innerPadding ->
    Column(modifier = Modifier.padding(innerPadding)) {

      GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = properties,
        uiSettings = uiSettings
      ) {
        Marker(
          state = MarkerState(position = LatLng(UCA.latitude, UCA.longitude)),
          title = UCA.name,
          snippet = UCA.remark
        )
      }
    }
  }
}