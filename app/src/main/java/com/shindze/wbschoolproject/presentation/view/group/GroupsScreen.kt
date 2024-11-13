package com.shindze.wbschoolproject.presentation.view.group

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shindze.wbschoolproject.molecules.GroupCard
import com.shindze.wbschoolproject.molecules.WBTopAppBar
import com.shindze.wbschoolproject.presentation.components.CustomTextField
import com.shindze.wbschoolproject.presentation.viewmodel.group.GroupsViewModel
import com.shindze.wbschoolproject.ui.theme.offWhite
import com.shindze.wbschoolproject.ui.theme.white


@Composable
internal fun GroupsScreen(title: String, onNavigateNext: (String) -> Unit, viewmodel: GroupsViewModel) {
    Scaffold(containerColor = white, topBar = {
        WBTopAppBar(title = title)
    }) { padding ->
        GroupsScreenBuilder(
            padding, viewmodel, onNavigateNext
        )
    }
}

@Composable
internal fun GroupsScreenBuilder(
    padding: PaddingValues,
    viewmodel: GroupsViewModel,
    onNavigateNext: (String) -> Unit
) {

    val groupList = viewmodel.getGroups().collectAsState().value

    LazyColumn(
        Modifier
            .padding(horizontal = 24.dp)
            .padding(padding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            CustomTextField(
                Modifier
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
        }
        items(groupList) { group ->
            group.imageUrl?.let {
                GroupCard(
                    name = group.title,
                    count = group.size.toString(),
                    avatar = it,
                    onClickNavigate = {
                        Log.e("GroupCard", "id: ${group.id}")
                        onNavigateNext(group.id)
                    },
                )
            }
        }
    }
}

