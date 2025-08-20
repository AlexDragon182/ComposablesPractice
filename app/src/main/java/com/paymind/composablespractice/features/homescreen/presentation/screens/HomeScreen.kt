package com.paymind.composablespractice.features.homescreen.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.paymind.composablespractice.config.navigation.NavigationWrapper

@Composable
fun HomeScreen (

){
    Scaffold (

    ){innerpadding ->
        Box (modifier = Modifier.padding(innerpadding)){
            Button(
                onClick = TODO(),
                modifier = TODO(),
                enabled = true,
                shape = TODO(),
                colors = TODO(),
                elevation = TODO(),
                border = TODO(),
                contentPadding = TODO(),
                interactionSource = TODO()
            ) {
                Text(text = "navegar a TimeScreen")
            }
        }


    }

}