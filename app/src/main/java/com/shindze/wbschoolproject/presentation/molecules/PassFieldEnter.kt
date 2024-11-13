package com.shindze.wbschoolproject.presentation.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.shindze.wbschoolproject.R
import com.shindze.wbschoolproject.ui.theme.HeadingTwo
import com.shindze.wbschoolproject.ui.theme.WBFontFamily
import com.shindze.wbschoolproject.ui.theme.active
import com.shindze.wbschoolproject.ui.theme.errorTint
import com.shindze.wbschoolproject.ui.theme.line

@Composable
fun PassFieldEnter(
    password: String,
    onPasswordChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    navigateToNextScreen: () -> Unit
) {
    val maxPasswordLength = 4
    val codeDefaultPassword = stringResource(R.string.CodeDefaultPassword)
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        BasicTextField(value = password,
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done, keyboardType = KeyboardType.NumberPassword
            ),
            onValueChange = { newPassword ->
                if (newPassword.length <= maxPasswordLength) {
                    onPasswordChanged(newPassword)
                    if (newPassword.length == maxPasswordLength) {
                        if (newPassword == codeDefaultPassword) {
                            navigateToNextScreen()
                            keyboardController?.hide()
                        } else {
                            keyboardController?.hide()
                        }
                    }
                }
            }) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(maxPasswordLength) { index ->
                    val number = when {
                        index >= password.length -> ""
                        else -> password[index].toString()
                    }
                    val textColor = when {
                        password.length == maxPasswordLength && password != codeDefaultPassword -> errorTint
                        else -> active
                    }
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(32.dp)) {
                        when {
                            number.isEmpty() -> {
                                Icon(
                                    painter = painterResource(id = R.drawable.dot),
                                    tint = line,
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                            }

                            else -> {
                                Text(
                                    text = number,
                                    fontFamily = WBFontFamily,
                                    style = HeadingTwo,
                                    color = textColor
                                )
                            }
                        }
                    }
                }

            }
        }
    }
}