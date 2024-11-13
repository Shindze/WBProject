package com.shindze.wbschoolproject.presentation.viewmodel.meet

import com.shindze.domain.model.MeetModel
import com.shindze.domain.model.ProfileModel
import com.shindze.wbschoolproject.presentation.viewmodel.state.MeetUiState
import com.shindze.wbschoolproject.presentation.viewmodel.state.ProfileUiState

internal class MeetsUiStateMapper {
    fun mapToUiState(meet: MeetModel): MeetUiState {
        return MeetUiState(
            id = meet.id,
            imageUrl = meet.imageUrl,
            name = meet.name,
            date = meet.date,
            isClosed = meet.isClosed,
            tagList = meet.tagList
        )
    }

    fun mapToUiStateList(meet: List<MeetModel>): List<MeetUiState> {
        return meet.map { mapToUiState(it) }
    }

    fun mapToProfileUiStateList(profiles: List<ProfileModel>): List<ProfileUiState> {
        return profiles.map { profile ->
            ProfileUiState(
                profileImage = profile.imageUrl,
                firstName = profile.firstName,
                lastName = profile.lastName,
                phoneNumber = profile.phoneNumber
            )
        }
    }
}
