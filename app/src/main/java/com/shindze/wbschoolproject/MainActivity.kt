package com.shindze.wbschoolproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.shindze.wbschoolproject.presentation.navigation.AuthNavigation
import com.shindze.wbschoolproject.ui.theme.WBSchoolProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WBSchoolProjectTheme {
                AuthNavigation()
            }
        }
    }
}


