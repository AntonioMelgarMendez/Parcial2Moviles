package com.pdmcourse.spotlyfe.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.pdmcourse.spotlyfe.ui.navigation.MainNavigation
import com.pdmcourse.spotlyfe.data.database.PlaceRepositoryImpl
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
@Composable
fun AppLayout() {
  val navController = rememberNavController()
  val context = LocalContext.current
  val repository = remember {
    PlaceRepositoryImpl(context)
  }

  MainNavigation(navController = navController, repository = repository)
}