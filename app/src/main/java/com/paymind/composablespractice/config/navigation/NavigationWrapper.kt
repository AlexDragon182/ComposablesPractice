package com.paymind.composablespractice.config.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.paymind.composablespractice.features.homescreen.presentation.screens.HomeScreen
import com.paymind.composablespractice.features.selesinforma.presentation.screens.TimeScreen

@Composable
fun NavigationWrapper(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeScreen){
        composable<HomeScreen>{
            HomeScreen()
        }

        composable<TimeScreen>{
            TimeScreen()
        }
    }
}