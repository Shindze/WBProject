package com.shindze.wbschoolproject.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.shindze.wbschoolproject.presentation.components.MeetingAvatar
import com.shindze.wbschoolproject.ui.theme.BodyOne
import com.shindze.wbschoolproject.ui.theme.MetadataOne
import com.shindze.wbschoolproject.ui.theme.WBFontFamily

@Composable
fun GroupCard(name: String, avatar: String, count: String, onClickNavigate: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClickNavigate()
            }, contentAlignment = Alignment.TopStart
    ) {
        Column {
            Row(Modifier.padding(8.dp)) {
                Column(Modifier.padding(4.dp)) {
                    MeetingAvatar(model = avatar)
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        name,
                        fontFamily = WBFontFamily,
                        style = BodyOne,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        count,
                        fontFamily = WBFontFamily,
                        style = MetadataOne,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                }
            }
            HorizontalDivider()
        }
    }
}