package com.ilhomsoliev.sp_history.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ilhomsoliev.sp_history.feature.detail.presentation.DetailsScreenComposable
import com.ilhomsoliev.sp_history.feature.main.presentation.MainScreenComposable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    snackbarHostState: SnackbarHostState,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {

            if (navBackStackEntry?.destination?.route == Screens.Main.route)
                TopAppBar(title = {
                    Text(text = "Hs History")
                }, navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                    }
                }, actions = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Info, contentDescription = null)
                    }
                })
        }
    ) { innerPadding ->
        NavHost(
            modifier = modifier.padding(innerPadding),
            navController = navController,
            startDestination = Screens.Main.route
        ) {

            MainScreenComposable(navController)

            DetailsScreenComposable(navController)

        }
    }
}