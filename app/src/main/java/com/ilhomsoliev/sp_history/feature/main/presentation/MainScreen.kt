package com.ilhomsoliev.sp_history.feature.main.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ilhomsoliev.sp_history.app.Screens
import com.ilhomsoliev.sp_history.feature.main.presentation.components.PeriodItem
import com.ilhomsoliev.sp_history.feature.main.presentation.components.PlaceItem
import com.ilhomsoliev.sp_history.shared.models.periods
import com.ilhomsoliev.sp_history.shared.models.places

fun NavGraphBuilder.MainScreenComposable(
    navController: NavController
) {
    composable(Screens.Main.route) {

        MainScreen(
            // vm = koinViewModel(),
            openDetails = {
                navController.navigate(Screens.Timetable.route) {
                    popUpTo(Screens.Login.route) { inclusive = true }
                    launchSingleTop = true
                }
            },
        )
    }
}

@Composable
fun MainScreen(
    openDetails: (Int) -> Unit,
) {
    LazyColumn(content = {
        item {// Periods
            LazyRow(content = {
                items(periods) {
                    PeriodItem(periodUiModel = it, onClick = {
                        // handle
                    })
                }
            })
        }

        items(places) {
            PlaceItem(placeUiModel = it, onClick = {
                openDetails(it.id)
            })
        }
    })
}