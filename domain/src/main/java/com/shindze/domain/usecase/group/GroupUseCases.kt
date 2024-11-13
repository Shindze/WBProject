package com.shindze.domain.usecase.group

import com.shindze.domain.model.GroupsModel
import kotlinx.coroutines.flow.Flow

interface GroupUseCases {
    fun getGroupsList(): Flow<List<GroupsModel>>
}
