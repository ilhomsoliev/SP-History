package com.ilhomsoliev.sp_history.shared.models

data class PlaceUiModel(
    val id: Int,
    val name: String,
    val isPassed: Boolean,
    val description: String,
    val imageUrl: String,
) {
}

val places = listOf(
    PlaceUiModel(
        id = 1,
        name = "Place1",
        isPassed = false,
        description = "Some descripton",
        imageUrl = "",
    ),
)