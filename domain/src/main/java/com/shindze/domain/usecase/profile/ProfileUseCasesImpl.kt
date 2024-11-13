package com.shindze.domain.usecase.profile

import com.shindze.domain.model.ProfileModel
import com.shindze.domain.repository.Repository

class ProfileUseCasesImpl(
    private val getProfileDataUseCase: GetProfileDataUseCase,
    private val setProfileDataUseCase: SetProfileDataUseCase,
) : ProfileUseCases {
    override suspend fun getProfile(): ProfileModel {
        return getProfileDataUseCase.execute()
    }

    override suspend fun setProfile(profile: ProfileModel) {
        return setProfileDataUseCase.execute(profile)
    }

}

class GetProfileDataUseCase(private val repository: Repository) {
    fun execute(): ProfileModel {
        return repository.getProfileData()
    }
}

class SetProfileDataUseCase(private val repository: Repository) {
    fun execute(profile: ProfileModel) {
        repository.setProfileData(profile)
    }
}

