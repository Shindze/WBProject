package com.shindze.wbschoolproject.presentation.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.shindze.wbschoolproject.presentation.navigation.AppNavigation
import com.shindze.wbschoolproject.presentation.navigation.BottomAppNavigation
import com.shindze.wbschoolproject.ui.theme.white

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    innerNavController: NavHostController = rememberNavController()
) {
    Scaffold(containerColor = white, content = { rootPadding ->
        AppNavigation(
            rootPadding, innerNavController
        )
    }, bottomBar = {
        BottomAppNavigation(
            innerNavController
        )
    }, modifier = Modifier.navigationBarsPadding()
    )
}


