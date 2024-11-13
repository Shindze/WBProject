package com.shindze.wbschoolproject.utils

object Constants {
    val allTabTitles = listOf("Все встречи", "Активные")
    val myTabTitles = listOf("Запланировано", "Уже прошли")

    val countryCodes = listOf("7", "1", "44", "91", "86", "999")


    const val STACKED_AVATARS_OFFSET = (-4 * 16)
    const val MAX_VISIBLE_AVATARS = 5
    const val MAX_PASSWORD_LENGTH = 10
    const val MAX_MEET_DESCRIPTION_LINE = 15
    const val PROFILE_IMAGE_SIZE = 200

    object TabSelection {
        const val ALL_TAB_SELECTED = 0
        const val ACTIVE_TAB_SELECTED = 1
    }
}