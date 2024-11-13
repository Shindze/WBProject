package com.shindze.domain.repository

import com.shindze.domain.model.GroupsModel
import com.shindze.domain.model.MeetModel
import com.shindze.domain.model.ProfileModel
import com.shindze.domain.model.SettingButtonModel
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getProfileData(): ProfileModel

    fun setProfileData(profile: ProfileModel)

    fun getMeetsListFlow(): Flow<List<MeetModel>>

    fun getGroupsListFlow(): Flow<List<GroupsModel>>

    fun getMeetGuestsListFlow(): Flow<List<ProfileModel>>

    fun getSettingsButtonListFlow(): Flow<List<SettingButtonModel>>

    fun getExtendedSettingsButtonListFlow(): Flow<List<SettingButtonModel>>
}
