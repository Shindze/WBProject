package com.shindze.wbschoolproject.presentation.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.shindze.wbschoolproject.presentation.components.PersonAvatar
import com.shindze.wbschoolproject.ui.theme.offWhite

@Composable
fun ProfileAvatar(
    backgroundSize: Int, imageSize: Int = backgroundSize, model: String? = null
) {
    Box(
        Modifier
            .size(backgroundSize.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(color = offWhite)
    ) {
        PersonAvatar(
            Modifier
                .size(imageSize.dp)
                .clip(RoundedCornerShape(100.dp)), model = model
        )
    }
}