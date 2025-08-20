package com.paymind.composablespractice.features.shared.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class CardItem(
    val text: String? = null,
    val icon: ImageVector? = null,
    val cardElevation: Dp = 5.dp,
    val labelColor: Color = Color.Black,
    val iconColor: Color = Color.Black,
    val textStyle: TextStyle? = null,
    val iconSize: Dp = 50.dp,
    val cardColor: Color? = null,
    val cardHeight: Dp = 180.dp,
    val onClick: () -> Unit,
)


@Composable
fun CustomGrid(
    gridPadding : PaddingValues,
    columnsNumber: Int,
    items: List<CardItem>,
    userScrollEnabled: Boolean = true
){
    //Obtenemos el ancho y alto del dispositivo
    val deviceWidth =  LocalContext.current.resources.displayMetrics.widthPixels
    val deviceHeight =  LocalContext.current.resources.displayMetrics.heightPixels

    LazyVerticalGrid(
        columns = GridCells.Fixed(columnsNumber),
        userScrollEnabled = userScrollEnabled,
        content = {
            itemsIndexed(items) { _, item ->
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = item.cardElevation
                    ),
                    onClick = item.onClick,
                    modifier = Modifier
                        .padding(gridPadding)
                        .size(
                            width = deviceWidth.dp / 2,
                            height = item.cardHeight
                        )
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally, // Centra horizontalmente
                        verticalArrangement = Arrangement.Center, // Centra verticalmente
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = item.cardColor!!)
                    ){
                        item.icon?.let {
                            Icon(
                                imageVector = it,
                                tint = item.iconColor,
                                contentDescription = "Icon",
                                modifier = Modifier.size(item.iconSize)
                            )
                        }

                        item.text?.let { text ->
                            item.textStyle?.let {
                                Text(
                                    text = text,
                                    style = it.copy(color = item.labelColor),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}