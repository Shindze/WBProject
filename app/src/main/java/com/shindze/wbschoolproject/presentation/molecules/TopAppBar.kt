package com.shindze.wbschoolproject.molecules

import androidx.annotation.DrawableRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.shindze.wbschoolproject.R
import com.shindze.wbschoolproject.ui.theme.SubheadingOne
import com.shindze.wbschoolproject.ui.theme.WBFontFamily
import com.shindze.wbschoolproject.ui.theme.active
import com.shindze.wbschoolproject.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WBTopAppBar(
    title: String? = null,
    additionalAction: TopAppBarAction? = null,
    navAction: TopAppBarAction? = null
) {
    TopAppBar(
        title = {
            title?.let {
                Text(
                    text = title, color = active, fontFamily = WBFontFamily, style = SubheadingOne
                )
            }
        },
        navigationIcon = {
            navAction?.let {
                IconButton(
                    onClick = navAction.onClick
                ) {
                    Icon(
                        painter = painterResource(
                            id = navAction.icon
                        ), contentDescription = null, tint = active
                    )
                }
            }
        },
        actions = {
            additionalAction?.let {
                IconButton(
                    onClick = additionalAction.onClick
                ) {
                    Icon(
                        painter = painterResource(id = additionalAction.icon),
                        contentDescription = null,
                        tint = active
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = white,
            titleContentColor = active
        )
    )
}

data class TopAppBarAction(
    @DrawableRes val icon: Int = R.drawable.arrow_back,
    val onClick: () -> Unit,
)
