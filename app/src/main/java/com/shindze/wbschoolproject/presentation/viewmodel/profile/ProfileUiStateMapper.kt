package com.shindze.wbschoolproject.presentation.viewmodel.profile

import com.shindze.domain.model.ProfileModel
import com.shindze.wbschoolproject.presentation.viewmodel.state.ProfileUiState

internal class ProfileUiStateMapper {
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