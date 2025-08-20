package com.paymind.composablespractice.config.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationWrapper(){
    val navController = rememberNavController()
    NavHost(navController = navController,)
}