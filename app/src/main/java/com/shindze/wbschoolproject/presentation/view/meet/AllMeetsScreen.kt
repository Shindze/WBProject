package com.shindze.wbschoolproject.presentation.view.meet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shindze.wbschoolproject.molecules.WBTopAppBar
import com.shindze.wbschoolproject.presentation.components.CustomTextField
import com.shindze.wbschoolproject.presentation.molecules.MeetCard
import com.shindze.wbschoolproject.presentation.viewmodel.meet.MeetsViewModel
import com.shindze.wbschoolproject.ui.theme.default
import com.shindze.wbschoolproject.ui.theme.offWhite
import com.shindze.wbschoolproject.ui.theme.offWhiteDisabled
import com.shindze.wbschoolproject.ui.theme.white
import com.shindze.wbschoolproject.utils.Constants.TabSelection.ACTIVE_TAB_SELECTED
import com.shindze.wbschoolproject.utils.Constants.TabSelection.ALL_TAB_SELECTED
import com.shindze.wbschoolproject.utils.Constants.allTabTitles

@Composable
internal fun AllMeetingsScreen(title: String, onNavigateNext: (String) -> Unit, viewmodel: MeetsViewModel) {
    Scaffold(containerColor = white, topBar = {
        WBTopAppBar(title = title)
    }) { padding ->
        AllMeetingsScreenBuilder(
            padding, viewmodel, onNavigateNext
        )
    }
}

@Composable
internal fun AllMeetingsScreenBuilder(
    padding: PaddingValues, viewmodel: MeetsViewModel, onNavigate: (String) -> Unit
) {
    var selectedTabIndex by remember { mutableIntStateOf(ALL_TAB_SELECTED) }
    val meetList by viewmodel.getMeetList().collectAsState()

    val filteredMeetList = when (selectedTabIndex) {
        ALL_TAB_SELECTED -> meetList
        ACTIVE_TAB_SELECTED -> meetList.filter { !it.isClosed }
        else -> meetList
    }

    Column(
        Modifier
            .padding(padding)
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTextField(
                modifier = Modifier
                    .background(
                        offWhite, RoundedCornerShape(4.dp)
                    )
                    .padding(4.dp)
                    .height(36.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Search, contentDescription = null
                    )
                },
            )
            TabRow(selectedTabIndex, containerColor = white, indicator = { tabPositions ->
                SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = default
                )
            }) {
                allTabTitles.forEachIndexed { index, title ->
                    Tab(text = { Text(title) },
                        selectedContentColor = default,
                        unselectedContentColor = offWhiteDisabled,
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index })
                }
            }
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(filteredMeetList) { meet ->
                MeetCard(meetUiState = meet, onClick = { onNavigate(meet.id) })
            }
        }
    }
}