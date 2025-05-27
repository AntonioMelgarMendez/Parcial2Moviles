package com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.NewPlaceScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.navOptions
import com.google.android.gms.maps.model.LatLng
import com.pdmcourse.spotlyfe.ui.components.SelectLocationMap
import com.pdmcourse.spotlyfe.ui.layout.CustomBack
import com.pdmcourse.spotlyfe.ui.navigation.SavedPlacesScreenNavigation

@Composable
fun NewPlaceScreen(
    navController: NavController
) {
    var placeName by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var position by remember { mutableStateOf(LatLng(13.679024407659101, -89.23578718993471)) }
    Scaffold(
        topBar = { CustomBack(navController, onBackPressed = {
            navController.navigate(SavedPlacesScreenNavigation, navOptions {
                launchSingleTop = true
                restoreState = true
            })
        }) },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.85f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = placeName,
                    onValueChange = { placeName = it },
                    label = { Text("Place Name") }
                )
                TextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") }
                )
                SelectLocationMap(
                    initialPosition = position,
                    onLocationChanged = { latLng ->
                        position = latLng
                    }
                )
                Button(onClick = {
                }) {
                    Text("Save Place")
                }
            }
        }
    }
}