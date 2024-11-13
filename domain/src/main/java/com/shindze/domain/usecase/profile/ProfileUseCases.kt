package com.shindze.domain.usecase.profile

import com.shindze.domain.model.ProfileModel

interface ProfileUseCases {
    suspend fun getProfile(): ProfileModel
    suspend fun setProfile(profile: ProfileModel)
}
