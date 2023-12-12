package com.ilhomsoliev.sp_history.feature.main.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            openDetails = {
                navController.navigate(Screens.DetailsScreen.buildRoute(it))
            },
        )
    }
}

@Composable
fun MainScreen(
    openDetails: (Int) -> Unit,
) {
    LazyColumn(content = {
        item {
            Spacer(modifier = Modifier.height(12.dp))
        }
        item {// Periods
            LazyRow(content = {
                items(periods) {
                    PeriodItem(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        periodUiModel = it, onClick = {
                            // handle
                        })
                }
            })
        }
        item {
            Spacer(modifier = Modifier.height(12.dp))
        }

        items(places) {
            PlaceItem(
                modifier = Modifier.padding(horizontal = 12.dp),
                placeUiModel = it,
                onClick = {
                    openDetails(it.id)
                })
            Spacer(modifier = Modifier.height(12.dp))

        }
    })
}