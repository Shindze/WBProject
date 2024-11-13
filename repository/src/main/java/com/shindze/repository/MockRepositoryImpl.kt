package com.shindze.repository

import com.shindze.domain.model.GroupsModel
import com.shindze.domain.model.MeetModel
import com.shindze.domain.model.ProfileModel
import com.shindze.domain.model.SettingButtonModel
import com.shindze.domain.repository.Repository
import com.shindze.repository.mock.MockData.getExtendedSettingsButtonListData
import com.shindze.repository.mock.MockData.getGroupsListData
import com.shindze.repository.mock.MockData.getGuestsListData
import com.shindze.repository.mock.MockData.getMeetsListData
import com.shindze.repository.mock.MockData.getSettingsListData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MockRepositoryImpl : Repository {
    override fun getProfileData(): ProfileModel = profile

    override fun setProfileData(profile: ProfileModel) {
        this.profile = profile
    }

    override fun getMeetsListFlow(): Flow<List<MeetModel>> = flowOf(
        getMeetsListData()
    )

    override fun getGroupsListFlow(): Flow<List<GroupsModel>> = flowOf(
        getGroupsListData()
    )

    override fun getMeetGuestsListFlow(): Flow<List<ProfileModel>> =
        flowOf(getGuestsListData())

    override fun getSettingsButtonListFlow(): Flow<List<SettingButtonModel>> =
        flowOf(getSettingsListData())

    override fun getExtendedSettingsButtonListFlow(): Flow<List<SettingButtonModel>> =
        flowOf(getExtendedSettingsButtonListData())

    private var profile = ProfileModel(
        id = "1",
        firstName = "Денис",
        lastName = "Радынов",
        imageUrl = "https://static.wikia.nocookie.net/avatar/images/f/f4/3%D1%8521_%D0%90%D0%B0%D0%BD%D0%B3.jpg/revision/latest?cb=20210125213454&path-prefix=ru",
        phoneCode = "+7",
        phoneNumber = "+79777109031"
    )
}
