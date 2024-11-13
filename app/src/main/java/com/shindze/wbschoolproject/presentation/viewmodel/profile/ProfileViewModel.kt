package com.shindze.wbschoolproject.presentation.viewmodel.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shindze.domain.usecase.profile.ProfileUseCases
import com.shindze.wbschoolproject.presentation.viewmodel.state.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class ProfileViewModel(private val profileUseCases: ProfileUseCases) : ViewModel() {

    private val profileUiStateMutable = MutableStateFlow(ProfileUiState())
    private val profileUiState: StateFlow<ProfileUiState> = profileUiStateMutable

    fun getProfile(): StateFlow<ProfileUiState> = profileUiState

    private fun getUserProfileData() {
        viewModelScope.launch {
            val profileData = profileUseCases.getProfile()
            val profileUiState = ProfileUiStateMapper().mapToProfileUiState(profileData)
            profileUiStateMutable.value = profileUiState
        }
    }

    init {
        getUserProfileData()
    }
}
