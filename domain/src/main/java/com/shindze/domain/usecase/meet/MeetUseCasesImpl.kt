package com.shindze.domain.usecase.meet

import com.shindze.domain.model.MeetModel
import com.shindze.domain.model.ProfileModel
import com.shindze.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class MeetUseCasesImpl(
    private val getMeetsDataUseCase: GetMeetsDataUseCase,
    private val getMeetsGuestUseCase: GetMeetsGuestUseCase
) : MeetUseCases {

    override fun getMeetsData(): Flow<List<MeetModel>> {
        return getMeetsDataUseCase.execute()
    }

    override fun getMeetsGuestData(): Flow<List<ProfileModel>> {
        return getMeetsGuestUseCase.execute()
    }
}

class GetMeetsDataUseCase(private val repository: Repository) {
    fun execute(): Flow<List<MeetModel>> {
        return repository.getMeetsListFlow()
    }
}

class GetMeetsGuestUseCase(private val repository: Repository) {
    fun execute(): Flow<List<ProfileModel>> {
        return repository.getMeetGuestsListFlow()
    }
}
