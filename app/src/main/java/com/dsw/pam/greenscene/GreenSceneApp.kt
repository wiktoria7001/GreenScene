package com.dsw.pam.greenscene

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dsw.pam.greenscene.ui.restaurant.RestaurantMapScreen
import com.dsw.pam.greenscene.ui.restaurant.RestaurantViewModel
import com.dsw.pam.greenscene.ui.theme.GreenSceneTheme
@Composable
fun GreenSceneApp() {
    GreenSceneTheme {
        val navController = rememberNavController()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Green Scene") },
                    backgroundColor = MaterialTheme.colors.primary
                )
            }
        ) { innerPadding ->
            AppNavigation(navController, innerPadding)
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController, contentPadding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = "map",
        modifier = Modifier.padding(contentPadding)
    ) {
        composable("map") {
            val restaurantViewModel: RestaurantViewModel = hiltViewModel()
            RestaurantMapScreen(viewModel = restaurantViewModel)
        }
        composable("profile") {
        }
    }
}

