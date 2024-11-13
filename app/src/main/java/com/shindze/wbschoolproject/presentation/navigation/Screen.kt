package com.shindze.wbschoolproject.presentation.navigation

import com.shindze.wbschoolproject.R

sealed class Screen(val route: String, val icon: Int? = null, val name: String = "") {
    data object Splash : Screen("splash_screen")
    data object NumberRequest : Screen("numberRequest_screen")
    data object CodeRequest : Screen("codeRequest_screen")
    data object ProfileSetup : Screen("profileSetup_screen")


    data object MainScreen : Screen("main_screen")


    data object AllMeetings :
        Screen("groups_screen", icon = R.drawable.coffee_togo, name = "Встречи")

    data object Groups :
        Screen("allMeetings_screen", icon = R.drawable.group_alt, name = "Сообщества")

    data object MoreTabScreen :
        Screen("moreTab_screen", icon = R.drawable.more_horizontal, name = "Ещё")


    data object DetailedMeetingScreen : Screen("detailedMeeting_screen", name = "Developer meeting")
    data object DetailedGroupScreen : Screen("detailedGroup_screen", name = "Designa")


    data object Profile :
        Screen("profile_screen", icon = R.drawable.more_horizontal, name = "Профиль")

    data object MyMeetings :
        Screen("myMeetings_screen", icon = R.drawable.group_alt, name = "Мои встречи")
}

val tabBarScreens = listOf(
    Screen.AllMeetings, Screen.Groups, Screen.MoreTabScreen
)
