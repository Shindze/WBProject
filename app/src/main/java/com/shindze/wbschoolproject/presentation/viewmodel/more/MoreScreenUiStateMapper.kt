package com.shindze.wbschoolproject.presentation.viewmodel.more

import com.shindze.domain.model.ProfileModel
import com.shindze.domain.model.SettingButtonModel
import com.shindze.wbschoolproject.presentation.viewmodel.state.ProfileUiState
import com.shindze.wbschoolproject.presentation.viewmodel.state.SettingButtonUiState

internal class MoreScreenUiStateMapper {
    private fun mapToSettingButtonUiState(button: SettingButtonModel): SettingButtonUiState {
        return SettingButtonUiState(
            name = button.name,
            iconResId = button.iconResId,
            onClick = button.onClick
        )
    }

    fun mapToSettingButtonUiStateList(buttons: List<SettingButtonModel>): List<SettingButtonUiState> {
        return buttons.map { mapToSettingButtonUiState(it) }
    }

    fun mapToProfileUiState(profile: ProfileModel): ProfileUiState {
        return ProfileUiState(
            profileImage = profile.imageUrl,
            firstName = profile.firstName,
            lastName = profile.lastName,
            phoneCode = profile.phoneCode,
            phoneNumber = profile.phoneNumber
        )
    }
}