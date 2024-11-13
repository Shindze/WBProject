package com.shindze.wbschoolproject.presentation.viewmodel.auth.number

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shindze.domain.model.ProfileModel
import com.shindze.domain.usecase.profile.ProfileUseCases
import com.shindze.wbschoolproject.presentation.viewmodel.state.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class NumberEnterViewModel(private val profileUseCases: ProfileUseCases) : ViewModel() {

    private val profileUiStateMutable = MutableStateFlow(ProfileUiState())
    private val profileUiState: StateFlow<ProfileUiState> = profileUiStateMutable

    fun getNewProfileData(): StateFlow<ProfileUiState> = profileUiState

    fun setPhoneCodeNumber(newPhoneCode: String) {
        profileUiStateMutable.value = profileUiStateMutable.value.copy(phoneCode = newPhoneCode)
    }

    fun setPhoneNumber(newPhoneNumber: String) {
        profileUiStateMutable.value = profileUiStateMutable.value.copy(phoneNumber = newPhoneNumber)
    }

    fun setProfilePhoneData() {
        viewModelScope.launch {
            val updatedProfile = ProfileModel.defaultValue.copy(
                phoneCode = getNewProfileData().value.phoneCode,
                phoneNumber = getNewProfileData().value.phoneNumber
            )
            profileUseCases.setProfile(updatedProfile)
        }
    }
}