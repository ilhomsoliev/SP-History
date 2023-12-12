package com.ilhomsoliev.sp_history.feature.main.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilhomsoliev.sp_history.shared.components.SCachedImage
import com.ilhomsoliev.sp_history.shared.models.PlaceUiModel

@Composable
fun PlaceItem(
    modifier: Modifier = Modifier,
    placeUiModel: PlaceUiModel,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable {
                onClick()
            }
    ) {
        SCachedImage(
            modifier = Modifier.fillMaxSize(),
            url = placeUiModel.imageUrl,
            placeholderColor = Color.Gray,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 12.dp, bottom = 12.dp)
        ) {
            Text(
                text = placeUiModel.name,
                color = Color.White,
                fontWeight = FontWeight.Black,
                fontSize = 34.sp
            )
            Text(
                text = placeUiModel.description, color = Color.White,
                fontWeight = FontWeight.Light,
                fontSize = 24.sp
            )
        }
    }

}