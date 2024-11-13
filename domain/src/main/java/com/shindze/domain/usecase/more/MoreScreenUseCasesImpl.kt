package com.shindze.domain.usecase.more

import com.shindze.domain.model.SettingButtonModel
import com.shindze.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class MoreScreenUseCasesImpl(
    private val getSettingsButtonUseCase: GetSettingsButtonUseCase,
    private val getExtendedSettingsButtonUseCase: GetExtendedSettingsButtonUseCase
) : MoreScreenUseCases {
    override fun getSettingsButtonList(): Flow<List<SettingButtonModel>> {
        return getSettingsButtonUseCase.execute()
    }

    override fun getExtendedSettingsButtonList(): Flow<List<SettingButtonModel>> {
        return getExtendedSettingsButtonUseCase.execute()
    }
}

class GetExtendedSettingsButtonUseCase(private val repository: Repository) {
    fun execute(): Flow<List<SettingButtonModel>> {
        return repository.getExtendedSettingsButtonListFlow()
    }
}

class GetSettingsButtonUseCase(private val repository: Repository) {
    fun execute(): Flow<List<SettingButtonModel>> {
        return repository.getSettingsButtonListFlow()
    }
}


