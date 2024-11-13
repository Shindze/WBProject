package com.shindze.ui.view.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shindze.wbschoolproject.R
import com.shindze.wbschoolproject.molecules.TopAppBarAction
import com.shindze.wbschoolproject.molecules.WBTopAppBar
import com.shindze.wbschoolproject.presentation.components.OutlinedButtonExample
import com.shindze.wbschoolproject.presentation.molecules.ProfileAvatar
import com.shindze.wbschoolproject.presentation.viewmodel.profile.ProfileViewModel
import com.shindze.wbschoolproject.ui.theme.HeadingTwo
import com.shindze.wbschoolproject.ui.theme.SubheadingOne
import com.shindze.wbschoolproject.ui.theme.WBFontFamily
import com.shindze.wbschoolproject.ui.theme.active
import com.shindze.wbschoolproject.ui.theme.default
import com.shindze.wbschoolproject.ui.theme.offWhiteDisabled
import com.shindze.wbschoolproject.ui.theme.white
import com.shindze.wbschoolproject.utils.Constants.PROFILE_IMAGE_SIZE

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun ProfileScreen(viewModel: ProfileViewModel, title: String, onBack: () -> Unit) {
    Scaffold(containerColor = white, topBar = {
        WBTopAppBar(title = title, navAction = TopAppBarAction(onClick = onBack))
    }) { padding ->
        ProfileScreenBuilder(
            padding, viewModel
        )
    }
}

@Composable
internal fun ProfileScreenBuilder(padding: PaddingValues, viewModel: ProfileViewModel) {

    val profile by viewModel.getProfile().collectAsState()

    Column(
        Modifier
            .padding(horizontal = 16.dp)
            .padding(padding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileAvatar(
            imageSize = PROFILE_IMAGE_SIZE,
            backgroundSize = PROFILE_IMAGE_SIZE,
            model = profile.profileImage
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "${profile.firstName} ${profile.lastName}",
                fontFamily = WBFontFamily,
                style = HeadingTwo,
                color = active
            )
            Text(
                text = "+${profile.phoneCode}${profile.phoneNumber}",
                fontFamily = WBFontFamily,
                style = SubheadingOne,
                color = offWhiteDisabled
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row {
            OutlinedButtonExample(
                buttonText = stringResource(id = R.string.ProfileButtonName),
                outlineButtonColors = ButtonDefaults.outlinedButtonColors(contentColor = default),
                outlineButtonBorderColors = BorderStroke(width = 2.dp, color = default),
                isEnable = true
            )
            Spacer(modifier = Modifier.width(12.dp))
            OutlinedButtonExample(
                buttonText = stringResource(id = R.string.ProfileButtonName),
                outlineButtonColors = ButtonDefaults.outlinedButtonColors(contentColor = default),
                outlineButtonBorderColors = BorderStroke(width = 2.dp, color = default),
                isEnable = true
            )
            Spacer(modifier = Modifier.width(12.dp))
            OutlinedButtonExample(
                buttonText = stringResource(id = R.string.ProfileButtonName),
                outlineButtonColors = ButtonDefaults.outlinedButtonColors(
                    contentColor = default
                ),
                outlineButtonBorderColors = BorderStroke(width = 2.dp, color = default),
                isEnable = true
            )
        }
    }
}