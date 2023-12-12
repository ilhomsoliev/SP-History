package com.ilhomsoliev.sp_history.feature.detail.presentation

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import coil.compose.AsyncImage
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.ilhomsoliev.sp_history.app.Screens
import com.ilhomsoliev.sp_history.shared.components.SCachedImage
import com.ilhomsoliev.sp_history.shared.models.getPlaceById

fun NavGraphBuilder.DetailsScreenComposable(
    navController: NavController
) {
    composable(route = Screens.DetailsScreen.route) {
        val id = Screens.DetailsScreen.getPersonId(it)
        DetailsScreen(
            // vm = koinViewModel(),
            id = id
        ) {
            navController.popBackStack()
        }
    }

}

@Composable
fun DetailsScreen(id: Int, onBack: () -> Unit) {
    val place = getPlaceById(id)
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            selectedImageUri = it
        }
    )

    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White), content = {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                SCachedImage(
                    modifier = Modifier.fillMaxSize(),
                    url = place.imageUrl,
                    contentScale = ContentScale.Crop

                )// url backround
                Text(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    text = place.name,
                    color = Color.White,
                    fontWeight = FontWeight.Black,
                    fontSize = 34.sp
                )
                IconButton(modifier = Modifier.align(Alignment.TopStart), onClick = {
                    onBack()
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
        item {
            Text(text = place.description)
        }
        item {
            // Upload Pic
            Button(modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0073E6),
                    contentColor = Color.White
                ),
                onClick = {
                    photoPickerLauncher.launch(
                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                    )
                }) {

                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_input_add),
                        contentDescription = "Add Image"
                    )
                    Text(
                        text = "Pick a Photo",
                        style = TextStyle(
                            fontSize = 18.sp
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.size(20.dp))

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .clip(RoundedCornerShape(16.dp)),
                model = selectedImageUri,
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

        }
        item {
            val singapore = LatLng(place.latitude, place.longitude)
            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(singapore, 10f)
            }
            GoogleMap(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(400.dp),
                cameraPositionState = cameraPositionState
            )
        }
    })
}