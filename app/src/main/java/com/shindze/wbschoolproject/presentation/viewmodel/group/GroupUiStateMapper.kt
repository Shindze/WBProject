package com.shindze.wbschoolproject.presentation.viewmodel.group

import com.shindze.domain.model.GroupsModel
import com.shindze.wbschoolproject.presentation.viewmodel.state.GroupUiState

internal class GroupUiStateMapper {
    fun mapToUiState(group: GroupsModel): GroupUiState {
        return GroupUiState(
            id = group.id,
            title = group.title,
            description = group.description,
            imageUrl = group.imageUrl,
            size = group.size
        )
    }

    fun mapToUiStateList(groups: List<GroupsModel>): List<GroupUiState> {
        return groups.map { mapToUiState(it) }
    }
}
