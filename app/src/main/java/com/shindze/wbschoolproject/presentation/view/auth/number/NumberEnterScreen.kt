package com.shindze.wbschoolproject.presentation.view.auth.number

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shindze.wbschoolproject.R
import com.shindze.wbschoolproject.presentation.components.FilledButtonExample
import com.shindze.wbschoolproject.presentation.molecules.CountryIndex
import com.shindze.wbschoolproject.presentation.molecules.PhoneField
import com.shindze.wbschoolproject.presentation.viewmodel.auth.number.NumberEnterViewModel
import com.shindze.wbschoolproject.ui.theme.BodyTwo
import com.shindze.wbschoolproject.ui.theme.HeadingTwo
import com.shindze.wbschoolproject.ui.theme.WBFontFamily
import com.shindze.wbschoolproject.ui.theme.default
import com.shindze.wbschoolproject.ui.theme.defaultOpacity
import com.shindze.wbschoolproject.ui.theme.white
import com.shindze.wbschoolproject.utils.Constants.MAX_PASSWORD_LENGTH

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun NumberEnterScreen(
    onNavigate: () -> Unit, viewModel: NumberEnterViewModel
) {
    Scaffold(containerColor = white) {
        NumberEnterScreenBuilder(onNavigate, viewModel)
    }
}

@Composable
internal fun NumberEnterScreenBuilder(onNavigate: () -> Unit, viewModel: NumberEnterViewModel) {

    val phoneNumber by viewModel.getNewProfileData().collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(96.dp))
                Text(
                    text = stringResource(R.string.EnterYourNumberText),
                    fontFamily = WBFontFamily,
                    style = HeadingTwo
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(R.string.SendCodeRequestText),
                    fontFamily = WBFontFamily,
                    style = BodyTwo
                )
            }
            Spacer(modifier = Modifier.height(48.dp))
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                CountryIndex(onCodeChanged = { viewModel.setPhoneCodeNumber(it) })
                Spacer(modifier = Modifier.width(8.dp))
                PhoneField(phone = phoneNumber.phoneNumber,
                    mask = stringResource(R.string.NumberMask),
                    maskNumber = '0',
                    onPhoneChanged = { viewModel.setPhoneNumber(it) })
                Spacer(modifier = Modifier.padding(64.dp))
            }
        }

        item {
            FilledButtonExample(
                onClick = {
                    keyboardController?.hide()
                    viewModel.setProfilePhoneData()
                    onNavigate()
                },
                elevateButtonColors = ButtonDefaults.elevatedButtonColors(
                    contentColor = white,
                    containerColor = default,
                    disabledContainerColor = defaultOpacity,
                    disabledContentColor = white
                ),
                isEnable = phoneNumber.phoneNumber.length == MAX_PASSWORD_LENGTH,
                buttonText = stringResource(R.string.NextButtonName),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            )
        }
    }
}








