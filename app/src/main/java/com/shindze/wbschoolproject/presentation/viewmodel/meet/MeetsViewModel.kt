package com.shindze.wbschoolproject.presentation.viewmodel.meet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shindze.domain.usecase.meet.MeetUseCases
import com.shindze.wbschoolproject.presentation.viewmodel.state.MeetUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class MeetsViewModel(private val meetUseCases: MeetUseCases) : ViewModel() {

    private val meetUiStateMutable = MutableStateFlow<List<MeetUiState>>(emptyList())
    private val meetUiState: StateFlow<List<MeetUiState>> = meetUiStateMutable

    fun getMeetList(): StateFlow<List<MeetUiState>> = meetUiState

    private fun getMeetListData(): StateFlow<List<MeetUiState>> {
        viewModelScope.launch {
            meetUseCases.getMeetsData().collect { meetList ->
                val meetUiStateList = MeetsUiStateMapper().mapToUiStateList(meetList)
                meetUiStateMutable.value = meetUiStateList
            }
        }
        return meetUiState
    }

    init {
        getMeetListData()
    }
}
