package com.shindze.wbschoolproject.presentation.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shindze.wbschoolproject.presentation.components.SmallPersonAvatar
import com.shindze.wbschoolproject.ui.theme.BodyOne
import com.shindze.wbschoolproject.ui.theme.WBFontFamily
import com.shindze.wbschoolproject.utils.Constants.MAX_VISIBLE_AVATARS
import com.shindze.wbschoolproject.utils.Constants.STACKED_AVATARS_OFFSET

@Composable
fun StackedAvatars(images: List<String?>, remainingCount: Int) {
    Box(
        modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            images.take(MAX_VISIBLE_AVATARS).forEachIndexed { index, avatar ->
                if (avatar != null) {
                    SmallPersonAvatar(
                        model = avatar,
                        modifier = Modifier.offset(x = (-index * 16).dp),
                    )
                }
            }
            Text(
                text = "+ $remainingCount",
                fontFamily = WBFontFamily,
                style = BodyOne,
                modifier = Modifier
                    .offset(x = STACKED_AVATARS_OFFSET.dp)
                    .padding(start = 8.dp)
            )
        }
    }
}