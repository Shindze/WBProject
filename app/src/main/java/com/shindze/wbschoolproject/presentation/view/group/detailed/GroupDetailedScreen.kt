package com.shindze.wbschoolproject.presentation.view.group.detailed

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.shindze.wbschoolproject.R
import com.shindze.wbschoolproject.molecules.TopAppBarAction
import com.shindze.wbschoolproject.molecules.WBTopAppBar
import com.shindze.wbschoolproject.presentation.molecules.MeetCard
import com.shindze.wbschoolproject.presentation.viewmodel.group.detailed.GroupsDetailedViewModel
import com.shindze.wbschoolproject.presentation.viewmodel.state.MeetUiState
import com.shindze.wbschoolproject.ui.theme.BodyOne
import com.shindze.wbschoolproject.ui.theme.MetadataOne
import com.shindze.wbschoolproject.ui.theme.WBFontFamily
import com.shindze.wbschoolproject.ui.theme.weak
import com.shindze.wbschoolproject.ui.theme.white

@Composable
internal fun GroupDetailedScreen(
    groupId: String,
    onNavigateNext: (String) -> Unit,
    onBack: () -> Unit,
    viewModel: GroupsDetailedViewModel,
) {

    val group = viewModel.loadGroup(groupId).collectAsState().value
    val meets = viewModel.getMeetList().collectAsState().value

    Scaffold(containerColor = white, topBar = {
        WBTopAppBar(title = group.title, navAction = TopAppBarAction(onClick = onBack))
    }) { padding ->
        GroupDetailedScreenBuilder(
            padding, meets, onNavigateNext
        )
    }
}

@Composable
internal fun GroupDetailedScreenBuilder(
    padding: PaddingValues,
    meetUiState: List<MeetUiState>,
    onNavigateNext: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .padding(padding)
    ) {
        item {
            Text(
                text = stringResource(id = R.string.GroupDescriptionText),
                color = weak,
                fontFamily = WBFontFamily,
                style = MetadataOne,
                maxLines = 15,
                overflow = TextOverflow.Clip
            )
            Spacer(modifier = Modifier.height(30.dp))
        }
        item {
            Text(
                text = stringResource(R.string.GroupsMeetings),
                color = weak,
                fontFamily = WBFontFamily,
                style = BodyOne,
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        items(meetUiState) { meet ->
            MeetCard(meetUiState = meet, onClick = { onNavigateNext(meet.id) })
        }
    }
}