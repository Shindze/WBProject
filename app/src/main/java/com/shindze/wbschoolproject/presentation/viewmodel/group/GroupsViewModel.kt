package com.shindze.wbschoolproject.presentation.viewmodel.group

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shindze.domain.usecase.group.GroupUseCases
import com.shindze.wbschoolproject.presentation.viewmodel.state.GroupUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class GroupsViewModel(
    private val groupUseCases: GroupUseCases
) : ViewModel() {

    private val groupListMutable = MutableStateFlow(emptyList<GroupUiState>())
    private val groupList: StateFlow<List<GroupUiState>> = groupListMutable

    private fun getGroupsList(): StateFlow<List<GroupUiState>> {
        viewModelScope.launch {
            groupUseCases.getGroupsList().collect { groupsList ->
                val groupUiStateList = GroupUiStateMapper().mapToUiStateList(groupsList)
                groupListMutable.value = groupUiStateList
            }
        }
        return groupList
    }

    fun getGroups(): StateFlow<List<GroupUiState>> = groupList

    init {
        getGroupsList()
    }
}
