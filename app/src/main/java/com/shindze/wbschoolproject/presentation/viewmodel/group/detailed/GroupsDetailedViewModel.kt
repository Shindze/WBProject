package com.shindze.wbschoolproject.presentation.viewmodel.group.detailed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shindze.domain.usecase.group.GroupUseCases
import com.shindze.domain.usecase.meet.MeetUseCases
import com.shindze.wbschoolproject.presentation.viewmodel.group.GroupUiStateMapper
import com.shindze.wbschoolproject.presentation.viewmodel.meet.MeetsUiStateMapper
import com.shindze.wbschoolproject.presentation.viewmodel.state.GroupUiState
import com.shindze.wbschoolproject.presentation.viewmodel.state.MeetUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

internal class GroupsDetailedViewModel(
    private val groupUseCases: GroupUseCases,
    private val meetUseCases: MeetUseCases,
) : ViewModel() {

    private val groupMutable = MutableStateFlow(GroupUiState())
    private val group: StateFlow<GroupUiState> = groupMutable

    private val meetModelListMutable = MutableStateFlow(emptyList<MeetUiState>())
    private val meetModelList: StateFlow<List<MeetUiState>> = meetModelListMutable

    fun getMeetList(): StateFlow<List<MeetUiState>> = meetModelList

    fun loadGroup(groupId: String): StateFlow<GroupUiState> {
        viewModelScope.launch {
            groupUseCases.getGroupsList().map { groups -> groups.find { it.id == groupId } }
                .collect { group ->
                    if (group != null) {
                        groupMutable.value = GroupUiStateMapper().mapToUiState(group)
                    }
                }
        }
        return group
    }

    private fun getMeetListData() {
        viewModelScope.launch {
            meetUseCases.getMeetsData().collect { meetList ->
                val meetUiStateList = MeetsUiStateMapper().mapToUiStateList(meetList)
                meetModelListMutable.value = meetUiStateList
            }
        }
    }

    init {
        getMeetListData()
    }
}
