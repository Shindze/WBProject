package com.shindze.wbschoolproject.presentation.viewmodel.state

internal data class SettingButtonUiState(
    val name: String = "",
    val iconResId: Int = 0,
    val onClick: () -> Unit = {}
)