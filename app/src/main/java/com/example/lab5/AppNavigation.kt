package com.example.lab5

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier

@Composable
fun AppNavigation(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(navController = navController,
        startDestination = "home",
        modifier = Modifier.padding(innerPadding)){
        composable("home") {
            HomeScreen(navController = navController)  // Pantalla principal
        }
        composable("list") {
            ListScreen(navController = navController)  // Pantalla de lista
        }
        composable("desc") {
            DescriptionScreen(navController = navController)  // Pantalla de descripción
        }
        composable("profile") {
            ProfileScreen(navController = navController)  // Pantalla de perfil
        }
    }
}