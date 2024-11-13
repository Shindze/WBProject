package com.shindze.wbschoolproject.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.shindze.wbschoolproject.R
import com.shindze.wbschoolproject.ui.theme.SubheadingTwo
import com.shindze.wbschoolproject.ui.theme.WBFontFamily

@Composable
fun FilledButtonExample(
    elevateButtonColors: ButtonColors,
    isEnable: Boolean,
    modifier: Modifier = Modifier,
    buttonText: String = stringResource(id = R.string.DefaultButtonName),
    onClick: () -> Unit = {},
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = elevateButtonColors,
        enabled = isEnable,
    ) {
        Text(buttonText, fontFamily = WBFontFamily, style = SubheadingTwo)
    }
}

@Composable
fun OutlinedButtonExample(
    outlineButtonColors: ButtonColors,
    outlineButtonBorderColors: BorderStroke,
    isEnable: Boolean,
    buttonText: String = stringResource(id = R.string.DefaultButtonName),
    onClick: () -> Unit = {},
) {
    OutlinedButton(
        onClick = { onClick() },
        colors = outlineButtonColors,
        enabled = isEnable,
        border = outlineButtonBorderColors
    ) {
        Text(buttonText)
    }
}

@Composable
fun TextButtonExample(
    textButtonColors: ButtonColors,
    isEnable: Boolean,
    text: String = stringResource(R.string.DefaultButtonName),
) {
    TextButton(
        onClick = { },
        enabled = isEnable,
        colors = textButtonColors,
    ) {
        Text(text, fontFamily = WBFontFamily, style = SubheadingTwo)
    }
}