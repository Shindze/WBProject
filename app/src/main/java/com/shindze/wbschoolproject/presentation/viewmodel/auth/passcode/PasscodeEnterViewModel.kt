package com.shindze.wbschoolproject.presentation.viewmodel.auth.passcode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shindze.domain.usecase.profile.ProfileUseCases
import com.shindze.wbschoolproject.presentation.viewmodel.state.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class PasscodeEnterViewModel(
    private val profileUseCases: ProfileUseCases,
) : ViewModel() {

    private val profileUiStateMutable = MutableStateFlow(ProfileUiState())
    private val profileUiState: StateFlow<ProfileUiState> = profileUiStateMutable

    private val passcodeMutable = MutableStateFlow("")
    private val passcode: StateFlow<String> = passcodeMutable

    fun getPasscode(): StateFlow<String> = passcode

    fun getProfileData(): StateFlow<ProfileUiState> = profileUiState

    fun setPassCode(pinCode: String) {
        passcodeMutable.value = pinCode
    }

    private fun getProfilePhoneData() {
        viewModelScope.launch {
            val phoneNumber = profileUseCases.getProfile().phoneNumber
            val phoneCode = profileUseCases.getProfile().phoneCode
            profileUiStateMutable.value = ProfileUiState(
                phoneCode = phoneCode,
                phoneNumber = phoneNumber
            )
        }
    }

    init {
        getProfilePhoneData()
    }
}