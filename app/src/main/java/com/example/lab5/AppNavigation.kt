package com.example.lab5

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier

@Composable
fun AppNavigation(navController: NavHostController, innerPadding: PaddingValues, viewModel: MainViewModel) {
    NavHost(navController = navController,
        startDestination = "home",
        modifier = Modifier.padding(innerPadding)){
        composable("home") {
            HomeScreen(navController = navController, viewModel)  // Pantalla principal
        }
        composable("list") {
            ListScreen(navController = navController, viewModel)  // Pantalla de lista
        }
        composable("desc/{itemId}") {
            val itemId = it.arguments?.getString("itemId")?.toIntOrNull() ?: 0
            val item = viewModel.items.find { it.id == itemId } ?: Item(0, "", 0, "", "", "")
            DescriptionScreen(navController, viewModel, itemId)   // Pantalla de descripción
        }
        composable("profile") {
            ProfileScreen(navController = navController)  // Pantalla de perfil
        }
    }
}