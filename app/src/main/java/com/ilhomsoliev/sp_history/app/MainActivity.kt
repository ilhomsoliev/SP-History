package com.ilhomsoliev.sp_history.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ilhomsoliev.sp_history.ui.theme.SPHistoryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController: NavHostController = rememberNavController()
            val snackbarHostState = remember { SnackbarHostState() }

            SPHistoryTheme {
                Navigation(navController = navController, snackbarHostState = snackbarHostState)
            }
        }
    }
}