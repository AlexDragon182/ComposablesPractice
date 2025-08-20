package com.paymind.composablespractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.paymind.composablespractice.config.navigation.NavigationWrapper

import com.paymind.composablespractice.config.theme.ComposablesPracticeTheme


data class MainActivityState (
    val error: String,
    val initialStartDateSelected:Long,
    val initialEndDateSelected:Long,
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposablesPracticeTheme {
                NavigationWrapper()
            }
        }
    }
}
