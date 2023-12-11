package com.ilhomsoliev.sp_history.feature.main.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ilhomsoliev.sp_history.shared.components.SCachedImage
import com.ilhomsoliev.sp_history.shared.models.PlaceUiModel

@Composable
fun PlaceItem(
    placeUiModel: PlaceUiModel,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable {
                onClick()
            }
    ) {
        SCachedImage(url = placeUiModel.imageUrl, placeholderColor = Color.Gray)
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Text(text = placeUiModel.name)
            Text(text = placeUiModel.description)
        }
    }

}