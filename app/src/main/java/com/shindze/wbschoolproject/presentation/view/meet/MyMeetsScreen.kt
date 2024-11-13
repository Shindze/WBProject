package com.shindze.wbschoolproject.presentation.view.meet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
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
import com.shindze.wbschoolproject.molecules.TopAppBarAction
import com.shindze.wbschoolproject.molecules.WBTopAppBar
import com.shindze.wbschoolproject.presentation.molecules.MeetCard
import com.shindze.wbschoolproject.presentation.viewmodel.meet.MeetsViewModel
import com.shindze.wbschoolproject.ui.theme.default
import com.shindze.wbschoolproject.ui.theme.offWhiteDisabled
import com.shindze.wbschoolproject.ui.theme.white
import com.shindze.wbschoolproject.utils.Constants.TabSelection.ACTIVE_TAB_SELECTED
import com.shindze.wbschoolproject.utils.Constants.TabSelection.ALL_TAB_SELECTED
import com.shindze.wbschoolproject.utils.Constants.myTabTitles

@Composable
internal fun MyMeetingsScreen(
    viewmodel: MeetsViewModel, title: String, onNavigateNext: (String) -> Unit, onBack: () -> Unit
) {
    Scaffold(containerColor = white, topBar = {
        WBTopAppBar(
            title = title, navAction = TopAppBarAction(onClick = onBack)
        )
    }) { padding ->
        MyMeetingsScreenBuilder(
            padding, viewmodel, onNavigateNext
        )
    }
}

@Composable
internal fun MyMeetingsScreenBuilder(
    padding: PaddingValues, viewmodel: MeetsViewModel, onNavigateNext: (String) -> Unit
) {
    var selectedTabIndex by remember { mutableIntStateOf(ALL_TAB_SELECTED) }
    val meetList = viewmodel.getMeetList().collectAsState().value

    val filteredMeetList = when (selectedTabIndex) {
        ALL_TAB_SELECTED -> meetList
        ACTIVE_TAB_SELECTED -> meetList.filter { !it.isClosed }
        else -> meetList
    }

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(padding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TabRow(selectedTabIndex, containerColor = white, indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                color = default,
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
            )
        }) {
            myTabTitles.forEachIndexed { index, title ->
                Tab(text = { Text(title) },
                    selectedContentColor = default,
                    unselectedContentColor = offWhiteDisabled,
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index })
            }
        }
        LazyColumn {
            items(filteredMeetList) { meet ->
                MeetCard(meetUiState = meet, onClick = { onNavigateNext(meet.id) })
            }
        }
    }
}