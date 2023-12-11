package com.ilhomsoliev.sp_history.shared.components

import android.net.Uri.parse
import android.util.Base64
import android.util.Base64.DEFAULT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.FilterQuality.Companion.High
import androidx.compose.ui.graphics.FilterQuality.Companion.Medium
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion.Fit
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImagePainter.State.Error
import coil.compose.AsyncImagePainter.State.Success
import coil.compose.rememberAsyncImagePainter
import coil.request.CachePolicy.ENABLED
import coil.request.ImageRequest
import coil.size.Size.Companion.ORIGINAL
import org.json.JSONObject
import java.io.File
import kotlin.text.Charsets.UTF_8

enum class CachedImageType {
    WEB, FILE, RESOURCE
}

@Composable
fun SCachedImage(
    url: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = Fit,
    alignment: Alignment = Center,
    alpha: Float = DefaultAlpha,
    contentDescription: String? = null,
    colorFilter: ColorFilter? = null,
    placeholderColor: Color = Transparent,
    type: CachedImageType = CachedImageType.WEB,
    refreshImage: (() -> Unit)? = null,
) {

    val context = LocalContext.current
    val key = url?.getPhotoKey()

    val builder = key(url) {
        remember(url) {
            val builder = ImageRequest
                .Builder(context)
                .data(url)
                .size(ORIGINAL)
                .networkCachePolicy(ENABLED)
                .diskCachePolicy(ENABLED)
                .memoryCachePolicy(ENABLED)
                .allowHardware(true)
                .crossfade(true)

            key?.let {
                builder.memoryCacheKey(key)
                builder.diskCacheKey(key)
            }
            builder.build()
        }
    }

    val painter = rememberAsyncImagePainter(
        model = builder,
        filterQuality = Medium,
        contentScale = contentScale,
    )

    LaunchedEffect(painter.state) {
        if (painter.state is Error)
            refreshImage?.let { it() }
    }
    Image(
        painter = url?.let {
            when (type) {
                CachedImageType.WEB -> painter
                CachedImageType.FILE -> rememberAsyncImagePainter(File(it))
                CachedImageType.RESOURCE -> painterResource(it.toInt())
            }
        } ?: rememberAsyncImagePainter(""),
        contentDescription = contentDescription,
        modifier = modifier
            .background(
                if (painter.state !is Success)
                    placeholderColor
                else Transparent
            ),
        alpha = alpha,
        alignment = alignment,
        contentScale = contentScale,
        colorFilter = colorFilter,
    )
}

private fun String.getPhotoKey() = try {
    parse(this)
        .getQueryParameter("policy")
        ?.let { policy ->
            Base64
                .decode(policy, DEFAULT)
                .toString(UTF_8)
                .let { JSONObject(it) }
                .let {
                    val path = it.getString("path")
                    val blur = it.getBoolean("blur")
                    "$path?blur=$blur"
                }
        }
} catch (e: Exception) {
    null
}