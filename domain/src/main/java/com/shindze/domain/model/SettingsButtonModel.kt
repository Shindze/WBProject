package com.shindze.domain.model

data class SettingButtonModel(
    val name: String,
    val iconResId: Int,
    val onClick: () -> Unit
) {
    companion object {
        val defaultValue = SettingButtonModel(
            name = "Button",
            iconResId = 0,
            onClick = {},
        )
    }
}