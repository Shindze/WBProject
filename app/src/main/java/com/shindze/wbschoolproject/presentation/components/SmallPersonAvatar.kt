package com.shindze.wbschoolproject.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.shindze.wbschoolproject.ui.theme.line

@Composable
fun SmallPersonAvatar(
    model: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = model,
        contentDescription = null,
        modifier = modifier
            .size(48.dp)
            .border(width = 2.dp, color = line, shape = RoundedCornerShape(16.dp))
            .clip(shape = RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Crop
    )
}