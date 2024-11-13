package com.shindze.wbschoolproject.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.shindze.wbschoolproject.presentation.components.PersonAvatar
import com.shindze.wbschoolproject.ui.theme.active
import com.shindze.wbschoolproject.ui.theme.offWhite
import com.shindze.wbschoolproject.ui.theme.white

@Composable
fun ProfileAvatarChange(
    backgroundSize: Int,
    imageSize: Int = backgroundSize,
    model: String? = null,
    onClick: () -> Unit = {}
) {
    Box {
        Box(
            Modifier
                .size(backgroundSize.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(color = offWhite)
                .clickable { onClick() }, contentAlignment = Alignment.Center
        ) {
            PersonAvatar(
                modifier = Modifier
                    .size(imageSize.dp)
                    .clip(RoundedCornerShape(100.dp)), model = model
            )
        }
        Box(
            modifier = Modifier
                .size(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color = active)
                .align(Alignment.BottomEnd)
                .padding(4.dp)
                .clickable { onClick() }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = white,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}