package com.ilhomsoliev.sp_history.shared.models

data class PeriodUiModel(
    val id: Int,
    val name: String,
    val description: String,
    val lessons: Int,
    val lessonsPassed: Int
)

val periods = listOf(
    PeriodUiModel(
        id = 1,
        name = "Period",
        description = "Some description",
        lessons = 60,
        lessonsPassed = 0,
    )
)