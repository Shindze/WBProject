package com.shindze.wbschoolproject.presentation.view.more

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.shindze.wbschoolproject.R
import com.shindze.wbschoolproject.molecules.WBTopAppBar
import com.shindze.wbschoolproject.presentation.molecules.ProfileAvatar
import com.shindze.wbschoolproject.presentation.navigation.Screen
import com.shindze.wbschoolproject.presentation.viewmodel.more.MoreScreenViewModel
import com.shindze.wbschoolproject.ui.theme.BodyOne
import com.shindze.wbschoolproject.ui.theme.MetadataOne
import com.shindze.wbschoolproject.ui.theme.WBFontFamily
import com.shindze.wbschoolproject.ui.theme.active
import com.shindze.wbschoolproject.ui.theme.offWhiteDisabled
import com.shindze.wbschoolproject.ui.theme.white

@Composable
internal fun MoreTabScreen(
    navController: NavHostController,
    viewModel: MoreScreenViewModel,
    title: String
) {
    Scaffold(containerColor = white, topBar = {
        WBTopAppBar(title = title)
    }) { padding ->
        MoreScreenBuilder(
            padding, navController, viewModel
        )
    }
}

@Composable
internal fun MoreScreenBuilder(
    padding: PaddingValues, navController: NavHostController, viewModel: MoreScreenViewModel
) {
    val buttons = viewModel.getButtons().collectAsState().value
    val extendedButtons = viewModel.getExtendedButtons().collectAsState().value
    LazyColumn(
        Modifier
            .padding(horizontal = 16.dp)
            .padding(padding)
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
            ProfileScreenButton(
                viewModel = viewModel,
                onNavigateNext = { navController.navigate(Screen.Profile.route) },
            )
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
            MyMeetingsButton(onNavigateNext = {
                navController.navigate(Screen.MyMeetings.route)
            })
        }
        items(buttons) { button ->
            Spacer(modifier = Modifier.height(8.dp))
            MoreSettingsButton(
                name = button.name, icon = button.iconResId, onClick = button.onClick
            )
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
        }
        items(extendedButtons) { button ->
            Spacer(modifier = Modifier.height(8.dp))
            MoreSettingsButton(
                name = button.name, icon = button.iconResId, onClick = button.onClick
            )
        }
    }
}

@Composable
internal fun ProfileScreenButton(viewModel: MoreScreenViewModel, onNavigateNext: () -> Unit) {

    val profile = viewModel.getProfile().collectAsState().value

    Row(modifier = Modifier
        .clickable { onNavigateNext() }
        .padding(vertical = 8.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            ProfileAvatar(
                backgroundSize = 48, imageSize = 48, model = profile.profileImage
            )
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "${profile.firstName} ${profile.lastName}",
                    fontFamily = WBFontFamily,
                    style = BodyOne
                )
                Text(
                    text = "+${profile.phoneCode}${profile.phoneNumber}",
                    fontFamily = WBFontFamily,
                    style = MetadataOne,
                    color = offWhiteDisabled
                )
            }
        }
        Icon(painter = painterResource(id = R.drawable.arrow), contentDescription = null)
    }
}

@Composable
fun MyMeetingsButton(onNavigateNext: () -> Unit) {
    Row(modifier = Modifier
        .clickable { onNavigateNext() }
        .padding(vertical = 8.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.coffee_togo), contentDescription = null
            )
            Text(
                text = stringResource(id = R.string.MyMeetingsLabel),
                fontFamily = WBFontFamily,
                style = BodyOne,
                color = active
            )
        }
        Icon(painter = painterResource(id = R.drawable.arrow), contentDescription = null)
    }
}

@Composable
fun MoreSettingsButton(name: String, icon: Int, onClick: () -> Unit) {
    Row(modifier = Modifier
        .clickable { onClick() }
        .padding(vertical = 8.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(painter = painterResource(id = icon), contentDescription = null)
            Text(
                text = name, fontFamily = WBFontFamily, style = BodyOne, color = active
            )
        }
        Icon(painter = painterResource(id = R.drawable.arrow), contentDescription = null)
    }
}


