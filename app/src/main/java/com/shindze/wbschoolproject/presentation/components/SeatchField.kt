package com.shindze.wbschoolproject.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shindze.wbschoolproject.R
import com.shindze.wbschoolproject.ui.theme.BodyOne
import com.shindze.wbschoolproject.ui.theme.WBFontFamily
import com.shindze.wbschoolproject.ui.theme.offWhiteDisabled

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    onTextChanged: (String) -> Unit = {},
    leadingIcon: (@Composable () -> Unit)? = null,
    supportText: String = stringResource(id = R.string.SearchFieldName)
) {
    BasicTextField(value = text, onValueChange = { newText ->
        onTextChanged(newText)
    }, singleLine = true, textStyle = BodyOne, decorationBox = { innerTextField ->
        Row(
            modifier, verticalAlignment = Alignment.CenterVertically
        ) {
            if (leadingIcon != null) {
                Box(Modifier.padding(4.dp)) {
                    leadingIcon()
                }
            }
            Box(Modifier.weight(1f)) {
                if (text.isEmpty()) Text(
                    supportText,
                    fontFamily = WBFontFamily,
                    style = BodyOne,
                    color = offWhiteDisabled
                )
                innerTextField()
            }
        }
    })
}
