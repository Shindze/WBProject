package com.shindze.wbschoolproject.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shindze.wbschoolproject.presentation.view.MainScreen
import com.shindze.wbschoolproject.presentation.view.auth.number.NumberEnterScreen
import com.shindze.wbschoolproject.presentation.view.auth.passcode.PasswordEnterScreen
import com.shindze.wbschoolproject.presentation.view.auth.profile.ProfileSetupScreen
import com.shindze.wbschoolproject.presentation.view.splash.CustomSplashScreen
import com.shindze.wbschoolproject.presentation.viewmodel.auth.number.NumberEnterViewModel
import com.shindze.wbschoolproject.presentation.viewmodel.auth.passcode.PasscodeEnterViewModel
import com.shindze.wbschoolproject.presentation.viewmodel.auth.profile.ProfileCreateViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthNavigation(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.Splash.route) {
            CustomSplashScreen(onNavigate = {
                navController.navigate(Screen.NumberRequest.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            })
        }
        composable(route = Screen.NumberRequest.route) {
            NumberEnterScreen(onNavigate = {
                navController.navigate(Screen.CodeRequest.route) {
                    popUpTo(Screen.NumberRequest.route) { inclusive = true }
                }
            }, viewModel = koinViewModel<NumberEnterViewModel>())
        }
        composable(route = Screen.CodeRequest.route) {
            PasswordEnterScreen(onNavigate = {
                navController.navigate(Screen.ProfileSetup.route) {
                    popUpTo(Screen.CodeRequest.route) { inclusive = true }
                }
            }, viewModel = koinViewModel<PasscodeEnterViewModel>())
        }
        composable(route = Screen.ProfileSetup.route) {
            ProfileSetupScreen(onNavigateNext = {
                navController.navigate(Screen.MainScreen.route) {
                    popUpTo(Screen.ProfileSetup.route) { inclusive = true }
                }
            }, onNavigateBack = {
                navController.navigate(Screen.NumberRequest.route) {
                    popUpTo(Screen.ProfileSetup.route) { inclusive = true }
                }
            }, viewModel = koinViewModel<ProfileCreateViewModel>())
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen()
        }
    }
}

