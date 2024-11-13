package com.shindze.wbschoolproject.presentation.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.shindze.wbschoolproject.R
import com.shindze.wbschoolproject.presentation.components.Chip
import com.shindze.wbschoolproject.presentation.components.MeetingAvatar
import com.shindze.wbschoolproject.presentation.viewmodel.state.MeetUiState
import com.shindze.wbschoolproject.ui.theme.BodyOne
import com.shindze.wbschoolproject.ui.theme.MetadataOne
import com.shindze.wbschoolproject.ui.theme.MetadataTwo
import com.shindze.wbschoolproject.ui.theme.WBFontFamily

@Composable
internal fun MeetCard(
    meetUiState: MeetUiState, onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }, contentAlignment = Alignment.TopStart
    ) {
        Column {
            Row(Modifier.padding(12.dp)) {
                meetUiState.imageUrl?.let {
                    MeetingAvatar(
                        model = it,
                        modifier = Modifier.padding(end = 12.dp, bottom = 12.dp)
                    )
                }
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        meetUiState.name,
                        fontFamily = WBFontFamily,
                        style = BodyOne,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        meetUiState.date,
                        fontFamily = WBFontFamily,
                        style = MetadataOne,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        meetUiState.tagList.forEach { chipName ->
                            Chip(name = chipName)
                        }
                    }
                }
            }
            Divider()
        }
        if (meetUiState.isClosed) {
            Text(
                text = stringResource(R.string.MeetingsStatusText),
                fontFamily = WBFontFamily,
                style = MetadataTwo,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 12.dp, top = 12.dp)
            )
        }
    }
}