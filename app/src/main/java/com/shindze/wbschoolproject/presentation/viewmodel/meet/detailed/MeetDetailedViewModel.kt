package com.shindze.wbschoolproject.presentation.viewmodel.meet.detailed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shindze.domain.usecase.meet.MeetUseCases
import com.shindze.wbschoolproject.presentation.viewmodel.meet.MeetsUiStateMapper
import com.shindze.wbschoolproject.presentation.viewmodel.state.MeetUiState
import com.shindze.wbschoolproject.presentation.viewmodel.state.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

internal class MeetDetailedViewModel(
    private val meetUseCases: MeetUseCases
) : ViewModel() {

    private val meetUiStateMutable = MutableStateFlow(MeetUiState())
    private val meetUiState: StateFlow<MeetUiState> = meetUiStateMutable

    private val eventGuestMutable = MutableStateFlow(emptyList<ProfileUiState>())
    private val eventGuest: StateFlow<List<ProfileUiState>> = eventGuestMutable

    fun loadMeet(meetId: String): StateFlow<MeetUiState> {
        viewModelScope.launch {
            meetUseCases.getMeetsData().map { meets -> meets.find { it.id == meetId } }
                .collect { meet ->
                    if (meet != null) {
                        meetUiStateMutable.value = MeetsUiStateMapper().mapToUiState(meet)
                    }
                }
        }
        return meetUiState
    }

    fun getMeetGuestList(): StateFlow<List<ProfileUiState>> {
        viewModelScope.launch {
            meetUseCases.getMeetsGuestData().collect { guestList ->
                val guestUiStateList = MeetsUiStateMapper().mapToProfileUiStateList(guestList)
                eventGuestMutable.value = guestUiStateList
            }
        }
        return eventGuest
    }

    init {
        getMeetGuestList()
    }
}
