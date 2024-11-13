package com.shindze.wbschoolproject.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.shindze.ui.view.profile.ProfileScreen
import com.shindze.wbschoolproject.presentation.view.group.GroupsScreen
import com.shindze.wbschoolproject.presentation.view.group.detailed.GroupDetailedScreen
import com.shindze.wbschoolproject.presentation.view.meet.AllMeetingsScreen
import com.shindze.wbschoolproject.presentation.view.meet.MyMeetingsScreen
import com.shindze.wbschoolproject.presentation.view.meet.detailed.MeetingDetailedScreen
import com.shindze.wbschoolproject.presentation.view.more.MoreTabScreen
import com.shindze.wbschoolproject.presentation.viewmodel.group.GroupsViewModel
import com.shindze.wbschoolproject.presentation.viewmodel.group.detailed.GroupsDetailedViewModel
import com.shindze.wbschoolproject.presentation.viewmodel.meet.MeetsViewModel
import com.shindze.wbschoolproject.presentation.viewmodel.meet.detailed.MeetDetailedViewModel
import com.shindze.wbschoolproject.presentation.viewmodel.more.MoreScreenViewModel
import com.shindze.wbschoolproject.presentation.viewmodel.profile.ProfileViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppNavigation(
    rootBottomPadding: PaddingValues,
    innerNavController: NavHostController,
) {
    NavHost(
        navController = innerNavController,
        startDestination = Screen.AllMeetings.route,
        Modifier.padding(bottom = rootBottomPadding.calculateBottomPadding())
    ) {
        composable(route = Screen.AllMeetings.route) {
            AllMeetingsScreen(
                title = Screen.AllMeetings.name,
                onNavigateNext = { meetId ->
                    innerNavController.navigate(
                        Screen.DetailedMeetingScreen.route + "/$meetId"
                    )
                },
                viewmodel = koinViewModel<MeetsViewModel>()
            )
        }
        composable(route = Screen.MyMeetings.route) {
            MyMeetingsScreen(title = Screen.MyMeetings.name,
                viewmodel = koinViewModel<MeetsViewModel>(),
                onNavigateNext = { meetId ->
                    innerNavController.navigate(
                        Screen.DetailedMeetingScreen.route + "/$meetId"
                    )
                },
                onBack = { innerNavController.popBackStack() })
        }
        composable(
            route = Screen.DetailedMeetingScreen.route + "/{meetId}",
            arguments = listOf(navArgument("meetId") { type = NavType.StringType })
        ) { backStackEntry ->
            val meetId = backStackEntry.arguments?.getString("meetId")
            if (meetId != null) {
                MeetingDetailedScreen(
                    meetId = meetId,
                    viewmodel = koinViewModel<MeetDetailedViewModel>(),
                    onBack = {
                        innerNavController.popBackStack()
                    },
                )
            }
        }
        composable(route = Screen.Groups.route) {
            GroupsScreen(
                title = Screen.Groups.name, viewmodel = koinViewModel<GroupsViewModel>(),
                onNavigateNext = { groupId ->
                    innerNavController.navigate(
                        Screen.DetailedGroupScreen.route + "/$groupId"
                    )
                },
            )
        }
        composable(
            route = Screen.DetailedGroupScreen.route + "/{groupId}",
            arguments = listOf(navArgument("groupId") { type = NavType.StringType })
        ) { backStackEntry ->
            val groupId = backStackEntry.arguments?.getString("groupId")
            if (groupId != null) {
                GroupDetailedScreen(groupId = groupId,
                    viewModel = koinViewModel<GroupsDetailedViewModel>(),
                    onNavigateNext = { meetId ->
                        innerNavController.navigate(
                            Screen.DetailedMeetingScreen.route + "/$meetId"
                        )
                    },
                    onBack = { innerNavController.popBackStack() })
            }
        }
        composable(route = Screen.MoreTabScreen.route) {
            MoreTabScreen(
                title = Screen.MoreTabScreen.name,
                navController = innerNavController,
                viewModel = koinViewModel<MoreScreenViewModel>()
            )
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen(title = Screen.Profile.name,
                viewModel = koinViewModel<ProfileViewModel>(),
                onBack = { innerNavController.popBackStack() })
        }
    }
}


