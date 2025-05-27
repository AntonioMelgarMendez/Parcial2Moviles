package com.pdmcourse.spotlyfe.ui.components


import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.google.android.gms.maps.model.LatLng

@Composable
fun ModalSavePlaces(
    onDismiss: () -> Unit,
    onSave: (String) -> Unit
) {
    var position by remember {mutableStateOf(LatLng(13.1,-79.1)) }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Save Place") },
        text = {
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("Place Name") }
            )
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("Description") }
            )
            SelectLocationMap(){
                latLng ->
                position = latLng
            }
        },
        confirmButton = {
            Button(onClick = { onSave("") }) {
                Text("Save")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}