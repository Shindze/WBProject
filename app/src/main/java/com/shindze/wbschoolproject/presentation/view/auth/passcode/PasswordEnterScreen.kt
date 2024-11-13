package com.shindze.wbschoolproject.presentation.view.auth.passcode

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.shindze.wbschoolproject.presentation.components.TextButtonExample
import com.shindze.wbschoolproject.presentation.molecules.PassFieldEnter
import com.shindze.wbschoolproject.presentation.viewmodel.auth.passcode.PasscodeEnterViewModel
import com.shindze.wbschoolproject.ui.theme.BodyTwo
import com.shindze.wbschoolproject.ui.theme.HeadingTwo
import com.shindze.wbschoolproject.ui.theme.WBFontFamily
import com.shindze.wbschoolproject.ui.theme.default
import com.shindze.wbschoolproject.ui.theme.white

@Composable
internal fun PasswordEnterScreen(onNavigate: () -> Unit, viewModel: PasscodeEnterViewModel) {
    Scaffold(containerColor = white) { paddingValues ->
        PasswordEnterScreenBuilder(
            Modifier.padding(paddingValues), viewModel, onNavigate
        )
    }
}

@Composable
internal fun PasswordEnterScreenBuilder(
    modifier: Modifier,
    viewModel: PasscodeEnterViewModel,
    onNavigate: () -> Unit,
) {

    val password = viewModel.getPasscode().collectAsState().value
    val profileData by viewModel.getProfileData().collectAsState()

    LazyColumn(
        modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(modifier = Modifier.height(96.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.CodeInputText),
                    fontFamily = WBFontFamily,
                    style = HeadingTwo
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(R.string.CodeShareToNumberText),
                    fontFamily = WBFontFamily,
                    style = BodyTwo
                )
                Text(
                    text = "+${profileData.phoneCode} ${profileData.phoneNumber}",
                    fontFamily = WBFontFamily,
                    style = BodyTwo
                )
            }
        }
        item {
            Spacer(modifier = Modifier.height(48.dp))
            PassFieldEnter(
                password = password,
                onPasswordChanged = { viewModel.setPassCode(it) },
                navigateToNextScreen = onNavigate
            )
        }
        item {
            Spacer(modifier = Modifier.height(64.dp))
            TextButtonExample(
                text = stringResource(R.string.CodeRequestButtonName),
                textButtonColors = ButtonDefaults.textButtonColors(contentColor = default),
                isEnable = true
            )
        }
    }
}