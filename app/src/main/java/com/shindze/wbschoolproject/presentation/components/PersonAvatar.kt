package com.shindze.wbschoolproject.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.shindze.wbschoolproject.R

@Composable
fun PersonAvatar(
    modifier: Modifier, model: String? = null
) {

    println(model.isNullOrEmpty())
    if (model.isNullOrEmpty()) {
        Image(
            painter = painterResource(id = R.drawable.person_outline),
            contentDescription = null,
            modifier = modifier.scale(0.5f),
            contentScale = ContentScale.Fit
        )
    }
    AsyncImage(
        model = model,
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.Crop,
    )
}