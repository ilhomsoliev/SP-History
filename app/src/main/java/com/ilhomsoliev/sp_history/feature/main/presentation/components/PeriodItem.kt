package com.ilhomsoliev.sp_history.feature.main.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ilhomsoliev.sp_history.shared.models.PeriodUiModel

@Composable
fun PeriodItem(
    periodUiModel: PeriodUiModel,
    onClick: () -> Unit,
) {

    Column(modifier = Modifier
        .width(200.dp)
        .clickable {
            onClick()
        }) {
        Text(text = periodUiModel.name)
        Text(text = periodUiModel.description)
        Text(text = "Passed: ${periodUiModel.lessonsPassed} out of ${periodUiModel.lessons}")

    }
}