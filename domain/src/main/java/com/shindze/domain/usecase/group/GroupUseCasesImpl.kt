package com.shindze.domain.usecase.group

import com.shindze.domain.model.GroupsModel
import com.shindze.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GroupUseCasesImpl(
    private val getMeetsDataUseCase: GetGroupsDataUseCase,
) : GroupUseCases {
    override fun getGroupsList(): Flow<List<GroupsModel>> {
        return getMeetsDataUseCase.execute()
    }
}

class GetGroupsDataUseCase(private val repository: Repository) {
    fun execute(): Flow<List<GroupsModel>> {
        return repository.getGroupsListFlow()
    }
}
