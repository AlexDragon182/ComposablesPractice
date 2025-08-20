package com.paymind.composablespractice.features.selesinforma.presentation.components

import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import java.time.LocalDateTime
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDateRangePicker(
    modifier: Modifier,
    title :String? = null,
    initialSelectedStartDateMilis: Long,
    initialSelectedEndDateMilis: Long,
    onDateRangeSelected: (Pair<Long?,Long?>) -> Unit

){
    val dateTime = LocalDateTime.now()

    val dateRangePickerState = rememberDateRangePickerState(
        initialSelectedStartDateMillis = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(),
        initialSelectedEndDateMillis = dateTime.plusDays(7).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
    )

    LaunchedEffect(dateRangePickerState.selectedStartDateMillis,dateRangePickerState.selectedEndDateMillis) {
        val start = dateRangePickerState.selectedStartDateMillis
        val end = dateRangePickerState.selectedEndDateMillis

        if (start != null && end != null){

        }


    }

    DateRangePicker(
        state = dateRangePickerState,
        modifier = modifier,
        title = { Text(text = title ?: "") },
        showModeToggle = false,
    )
}