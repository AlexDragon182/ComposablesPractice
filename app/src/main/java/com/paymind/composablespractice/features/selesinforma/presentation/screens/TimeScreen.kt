package com.paymind.composablespractice.features.selesinforma.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Composable
fun TimeScreen (

) {
    val snackbarHostState = remember { SnackbarHostState() }


    val date = remember { LocalDate.now() }//reflects local date and local time of user,
    val dateMath = remember { LocalDate.now().plusDays(7) }
    val time = remember {
        LocalTime.now().plusHours(50)
    }//contains information of miliseconds and nanoseconds
    val dateTime = remember { LocalDateTime.now().plusHours(50) }
    val dateTimeFramed = remember { LocalDateTime.of(2023, 11, 1, 3, 55) }
    //val dateTimeParse = remember { LocalDateTime.parse(string)}
    val dateTimeParse = remember { ZonedDateTime.now() } // information about time zone
    val dateTimeParseInSeconds =
        remember { ZonedDateTime.now().toEpochSecond() * 1000 } // information about time zone
    //Zone Date Time Object
    val dateTimeObject = remember {
        ZonedDateTime.ofInstant(//construct this with a timeStamp
            Instant.ofEpochMilli(System.currentTimeMillis()),// instante en milisegundos (tiempo actual)
            //ZoneId.systemDefault()//Zona Horaria de Systema
            ZoneId.of("Asia/Tokyo")//Zona Horaria de Systema
        )
    }

    val formattedDate = remember {
        DateTimeFormatter.ofPattern("EEE dd MM yyyy HH:mm:ss").format(dateTimeObject)
    }

    Scaffold(
        topBar = {
            Text(text = "Time")

        },
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.fillMaxWidth()
            )
        },
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(it),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text(text = date.toString())
                Text(text = dateMath.toString())
                Text(text = time.toString())
                Text(text = dateTime.toString())
                Text(text = dateTimeFramed.toString())
                Text(text = dateTimeParse.toString())
                Text(text = dateTimeParseInSeconds.toString())
                Text(text = dateTimeObject.toString())
                Text(text = formattedDate.toString())
            }

        }
    }
}