package com.shindze.domain.usecase.more

import com.shindze.domain.model.SettingButtonModel
import kotlinx.coroutines.flow.Flow

interface MoreScreenUseCases {
    fun getSettingsButtonList(): Flow<List<SettingButtonModel>>
    fun getExtendedSettingsButtonList(): Flow<List<SettingButtonModel>>
}
