package com.ilhomsoliev.sp_history.shared.models

data class PlaceUiModel(
    val id: Int,
    val name: String,
    val isPassed: Boolean,
    val description: String,
    val imageUrl: String,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
)

fun getPlaceById(id: Int): PlaceUiModel = places.find { it.id == id }!!

val places = listOf(
    PlaceUiModel(
        id = 1,
        name = "Place1",
        isPassed = false,
        description = "Some descripton",
        imageUrl = "https://luxurycolumnist.com/wp-content/uploads/2022/02/petra-jordan.jpg",

    ),
    PlaceUiModel(
        id = 2,
        name = "Place1",
        isPassed = false,
        description = "Some descripton",
        imageUrl = "https://luxurycolumnist.com/wp-content/uploads/2022/02/petra-jordan.jpg"
    ),
)