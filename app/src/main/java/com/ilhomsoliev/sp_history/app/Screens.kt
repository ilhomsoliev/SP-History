package com.ilhomsoliev.sp_history.app

import androidx.navigation.NavBackStackEntry

sealed class Screens(val route: String) {
    data object Timetable : Screens("Timetable")
    data object Profile : Screens("Profile")
    data object Info : Screens("Info")
    data object Main : Screens("Main")

    data object Login : Screens("Login/{isLoginOpened}") {
        fun buildRoute(isLoginOpened: Int): String = "Login/${isLoginOpened}"
        fun getIsLoginOpened(entry: NavBackStackEntry): Boolean =
            (entry.arguments!!.getString("isLoginOpened") ?: "0") == "1"
    }
}