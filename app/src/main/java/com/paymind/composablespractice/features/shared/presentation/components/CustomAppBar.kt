package com.paymind.composablespractice.features.shared.presentation.components


import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.paymind.composablespractice.config.theme.CustomPrimaryColor

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CustomAppBar(
    containerColor: Color = CustomPrimaryColor,
    trailingText: String? = null,
    textStyle: TextStyle? =  MaterialTheme.typography.titleLarge,
    showBackButton: Boolean = false,
    iconBackColor: Color = Color.White,
    onBackAction: () -> Unit = {},
    actions: @Composable() (RowScope.() -> Unit) = {}
) {

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = containerColor,
            titleContentColor = Color.White
        ),
        title = {
            trailingText?.let { text ->
                textStyle?.let { style ->
                    Text(
                        text = text,
                        style = style
                    )
                } ?: Text(text = text)
            }
        },
        navigationIcon = {
            if (showBackButton) {
                IconButton(
                    onClick = onBackAction,
                    content = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Boton para regresar",
                            tint = iconBackColor
                        )
                    }
                )
            }
        },
        actions = actions
    )
}