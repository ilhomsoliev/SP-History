package com.ilhomsoliev.sp_history.app

import androidx.navigation.NavBackStackEntry

sealed class Screens(val route: String) {
    data object Timetable : Screens("Timetable")
    data object Profile : Screens("Profile")
    data object Info : Screens("Info")
    data object Main : Screens("Main")

    data object DetailsScreen : Screens("Details/{personId}") {
        fun buildRoute(personId: Int): String =
            "Details/${personId}"

        fun getPersonId(entry: NavBackStackEntry): Int =
            entry.arguments!!.getString("personId")?.toInt()
                ?: throw IllegalArgumentException("personId argument missing.")


    }

}