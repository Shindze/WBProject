package com.shindze.wbschoolproject.presentation.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.shindze.wbschoolproject.R
import com.shindze.wbschoolproject.presentation.view.auth.number.PhoneVisualTransformation
import com.shindze.wbschoolproject.ui.theme.BodyOne
import com.shindze.wbschoolproject.ui.theme.WBFontFamily
import com.shindze.wbschoolproject.ui.theme.offWhite
import com.shindze.wbschoolproject.ui.theme.offWhiteDisabled
import com.shindze.wbschoolproject.utils.Constants.countryCodes

@Composable
fun CountryIndex(onCodeChanged: (String) -> Unit) {

    var expanded by remember { mutableStateOf(false) }
    var selectedCode by remember { mutableStateOf("7") }

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(offWhite)
            .clickable { expanded = true },
        contentAlignment = Alignment.Center
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(painter = painterResource(id = R.drawable.flag), contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "+$selectedCode", fontFamily = WBFontFamily, style = BodyOne)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(offWhite)
                .clip(RoundedCornerShape(8.dp))
        ) {
            countryCodes.forEach { code ->
                DropdownMenuItem(
                    onClick = {
                        selectedCode = code
                        onCodeChanged(selectedCode)
                        expanded = false
                    }
                ) {
                    Text(text = "+$code", fontFamily = WBFontFamily, style = BodyOne)
                }
            }
        }
    }
}


@Composable
fun PhoneField(
    phone: String,
    modifier: Modifier = Modifier,
    mask: String = stringResource(R.string.NumberMask),
    maskNumber: Char = '0',
    onPhoneChanged: (String) -> Unit,
    placeholder: String = stringResource(R.string.NumberMask)
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(offWhite)
    ) {
        BasicTextField(
            value = phone,
            onValueChange = {
                onPhoneChanged(it.take(mask.count { char -> char == maskNumber }))
            },
            singleLine = true,
            textStyle = BodyOne,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            visualTransformation = PhoneVisualTransformation(mask, maskNumber),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(horizontal = 8.dp)
        )

        if (phone.isEmpty()) {
            Text(
                text = placeholder,
                color = offWhiteDisabled,
                style = BodyOne,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterStart)
                    .padding(horizontal = 8.dp)
            )
        }
    }
}