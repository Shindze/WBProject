package com.shindze.wbschoolproject.presentation.view.meet.detailed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.shindze.wbschoolproject.R
import com.shindze.wbschoolproject.presentation.molecules.StackedAvatars
import com.shindze.wbschoolproject.molecules.TopAppBarAction
import com.shindze.wbschoolproject.molecules.WBTopAppBar
import com.shindze.wbschoolproject.presentation.components.Chip
import com.shindze.wbschoolproject.presentation.components.FilledButtonExample
import com.shindze.wbschoolproject.presentation.viewmodel.meet.detailed.MeetDetailedViewModel
import com.shindze.wbschoolproject.presentation.viewmodel.state.MeetUiState
import com.shindze.wbschoolproject.ui.theme.BodyOne
import com.shindze.wbschoolproject.ui.theme.MetadataOne
import com.shindze.wbschoolproject.ui.theme.MetadataTwo
import com.shindze.wbschoolproject.ui.theme.WBFontFamily
import com.shindze.wbschoolproject.ui.theme.default
import com.shindze.wbschoolproject.ui.theme.weak
import com.shindze.wbschoolproject.ui.theme.white
import com.shindze.wbschoolproject.utils.Constants.MAX_MEET_DESCRIPTION_LINE
import com.shindze.wbschoolproject.utils.Constants.MAX_VISIBLE_AVATARS


@Composable
internal fun MeetingDetailedScreen(viewmodel: MeetDetailedViewModel, onBack: () -> Unit, meetId: String) {
    val meet = viewmodel.loadMeet(meetId).collectAsState().value
    Scaffold(containerColor = white, topBar = {
        WBTopAppBar(title = meet.name, navAction = TopAppBarAction(onClick = onBack))
    }) { padding ->
        MeetingDetailedScreenBuilder(
            padding, meet, viewmodel
        )
    }
}

@Composable
internal fun MeetingDetailedScreenBuilder(
    padding: PaddingValues,
    meetModel: MeetUiState,
    viewmodel: MeetDetailedViewModel
) {
    val guestsList = viewmodel.getMeetGuestList().collectAsState().value

    val avatars = guestsList.map { it.profileImage }
    val visibleAvatars = avatars.take(MAX_VISIBLE_AVATARS)
    val remainingCount = guestsList.size - MAX_VISIBLE_AVATARS

    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .padding(padding),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = meetModel.date,
                        color = weak,
                        fontFamily = WBFontFamily,
                        style = BodyOne,
                        overflow = TextOverflow.Clip
                    )
                    if (meetModel.isClosed) {
                        Text(
                            text = stringResource(R.string.MeetingsStatusText),
                            fontFamily = WBFontFamily,
                            style = MetadataTwo,
                        )
                    }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    meetModel.tagList.forEach {
                        Chip(name = it)
                    }
                }
            }
        }
        item {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                AsyncImage(
                    modifier = Modifier.clip(RoundedCornerShape(24.dp)),
                    model = stringResource(R.string.MeetingCardImgURL),
                    contentDescription = null,
                )
                Text(
                    text = stringResource(id = R.string.GroupDescriptionText),
                    color = weak,
                    fontFamily = WBFontFamily,
                    style = MetadataOne,
                    maxLines = MAX_MEET_DESCRIPTION_LINE,
                    overflow = TextOverflow.Clip
                )
                StackedAvatars(images = visibleAvatars, remainingCount = remainingCount)
                FilledButtonExample(elevateButtonColors = ButtonDefaults.buttonColors(
                    containerColor = default, contentColor = white
                ),
                    isEnable = true,
                    modifier = Modifier
                        .defaultMinSize(minHeight = 52.dp)
                        .fillParentMaxWidth(),
                    buttonText = stringResource(R.string.MeetingScreenButtonName),
                    onClick = { })
            }
        }
    }
}