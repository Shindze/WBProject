package com.shindze.domain.usecase.meet

import com.shindze.domain.model.MeetModel
import com.shindze.domain.model.ProfileModel
import kotlinx.coroutines.flow.Flow

interface MeetUseCases {
    fun getMeetsData(): Flow<List<MeetModel>>
    fun getMeetsGuestData(): Flow<List<ProfileModel>>
}
