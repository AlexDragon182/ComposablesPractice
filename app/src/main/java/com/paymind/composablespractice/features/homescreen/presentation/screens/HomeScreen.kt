package com.paymind.composablespractice.features.homescreen.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paymind.composablespractice.R
import com.paymind.composablespractice.config.theme.CustomBackgroundColor
import com.paymind.composablespractice.config.theme.CustomButtonColor
import com.paymind.composablespractice.config.theme.CustomIconColor
import com.paymind.composablespractice.config.theme.CustomTextColor
import com.paymind.composablespractice.features.shared.presentation.components.CardItem
import com.paymind.composablespractice.features.shared.presentation.components.CustomAppBar
import com.paymind.composablespractice.features.shared.presentation.components.CustomGrid

@Composable
fun HomeScreen (
    navigateToTime: () -> Unit,
    navigateToCharacter: () -> Unit,

) {

    val items = mutableListOf<CardItem>()

    items.addAll(
        listOf(
            CardItem(
                text = "Informarles",
                icon = Icons.Outlined.DateRange,
                iconColor = CustomIconColor,
                textStyle = MaterialTheme.typography.labelLarge.copy(color = CustomTextColor),
                onClick = {navigateToTime()},
                cardColor = CustomBackgroundColor
            ),
            CardItem(
                text = "Create your Character",
                icon = Icons.Outlined.Person,
                iconColor = CustomIconColor,
                textStyle = MaterialTheme.typography.labelLarge.copy(color = CustomTextColor),
                onClick = {navigateToCharacter()},
                cardColor = CustomBackgroundColor
            ),
        )
    )


    Scaffold (
        modifier = Modifier.background(color = CustomBackgroundColor),
        topBar = { CustomAppBar(
            trailingText = "B-MO Always Bounces Back",
            textStyle = MaterialTheme.typography.titleLarge.copy(color = CustomTextColor),
            actions = {
                IconButton(
                    onClick = {},
                    colors = IconButtonColors(
                        containerColor = CustomButtonColor,
                        contentColor = CustomIconColor,
                        disabledContainerColor = Color.Black,
                        disabledContentColor = Color.White,
                    )

                ) {
                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = "Boton para algo",
                        tint = CustomIconColor
                    )
                }
            }
        ) }

    ){innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding).fillMaxWidth()
        ){
            CustomGrid(
                gridPadding = PaddingValues(vertical = 15.dp , horizontal = 10.dp),
                columnsNumber = 2,
                items = items
            )
        }
    }
}

/*@Preview
@Composable
fun MyHomeScreenPreview() {
    HomeScreen(navigateToTime = )
}*/