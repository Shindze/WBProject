package com.shindze.wbschoolproject.presentation.viewmodel.more

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shindze.domain.usecase.more.MoreScreenUseCases
import com.shindze.domain.usecase.profile.ProfileUseCases
import com.shindze.wbschoolproject.presentation.viewmodel.state.ProfileUiState
import com.shindze.wbschoolproject.presentation.viewmodel.state.SettingButtonUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class MoreScreenViewModel(
    private val moreScreenUseCases: MoreScreenUseCases, private val profileUseCases: ProfileUseCases
) : ViewModel() {

    private val profileUiStateMutable = MutableStateFlow(ProfileUiState())
    private val profileUiState: StateFlow<ProfileUiState> = profileUiStateMutable

    private val settingsButtonMutable = MutableStateFlow(emptyList<SettingButtonUiState>())
    private val settingsButton: StateFlow<List<SettingButtonUiState>> = settingsButtonMutable

    private val extendedSettingsButtonMutable = MutableStateFlow(emptyList<SettingButtonUiState>())
    private val extendedSettingsButton: StateFlow<List<SettingButtonUiState>> =
        extendedSettingsButtonMutable

    fun getProfile(): StateFlow<ProfileUiState> = profileUiState
    fun getButtons(): StateFlow<List<SettingButtonUiState>> = settingsButton
    fun getExtendedButtons(): StateFlow<List<SettingButtonUiState>> = extendedSettingsButton

    private fun getSettingsButton() {
        viewModelScope.launch {
            moreScreenUseCases.getSettingsButtonList().collect { buttonsList ->
                val buttonStateModel =
                    MoreScreenUiStateMapper().mapToSettingButtonUiStateList(buttonsList)
                settingsButtonMutable.value = buttonStateModel
            }
        }
    }

    private fun getExtendedSettingsButton() {
        viewModelScope.launch {
            viewModelScope.launch {
                moreScreenUseCases.getExtendedSettingsButtonList().collect { buttonsList ->
                    val buttonStateModel =
                        MoreScreenUiStateMapper().mapToSettingButtonUiStateList(buttonsList)
                    extendedSettingsButtonMutable.value = buttonStateModel
                }
            }
        }
    }

    private fun getUserProfileData() {
        viewModelScope.launch {
            val profileData = profileUseCases.getProfile()
            val profileUiState = MoreScreenUiStateMapper().mapToProfileUiState(profileData)
            profileUiStateMutable.value = profileUiState
        }
    }

    init {
        getUserProfileData()
        getSettingsButton()
        getExtendedSettingsButton()
    }
}
