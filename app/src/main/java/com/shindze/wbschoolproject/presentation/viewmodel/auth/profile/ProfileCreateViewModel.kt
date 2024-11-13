package com.shindze.wbschoolproject.presentation.viewmodel.auth.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shindze.domain.model.ProfileModel
import com.shindze.domain.usecase.profile.ProfileUseCases
import com.shindze.wbschoolproject.presentation.viewmodel.state.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class ProfileCreateViewModel(
    private val profileUseCases: ProfileUseCases,
) : ViewModel() {

    private val stateMutable = MutableStateFlow(ProfileUiState())
    private val state: StateFlow<ProfileUiState> = stateMutable

    fun getProfileState(): StateFlow<ProfileUiState> = state

    fun setProfileImage(profileImage: String?) {
        stateMutable.value = stateMutable.value.copy(profileImage = profileImage)
    }

    fun setProfileData(firstName: String, lastName: String = "", profileImage: String? = "") {
        viewModelScope.launch {

            val phoneCode = profileUseCases.getProfile().phoneCode
            val phoneNumber = profileUseCases.getProfile().phoneNumber

            Log.e("setProfileData", "$phoneCode, $phoneNumber")

            profileUseCases.setProfile(
                ProfileModel.defaultValue.copy(
                    firstName = firstName,
                    lastName = lastName,
                    imageUrl = profileImage,
                    phoneCode = phoneCode,
                    phoneNumber = phoneNumber
                )
            )
        }
    }
}