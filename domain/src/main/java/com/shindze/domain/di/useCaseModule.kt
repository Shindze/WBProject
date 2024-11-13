package com.shindze.domain.di


import com.shindze.domain.usecase.group.GetGroupsDataUseCase
import com.shindze.domain.usecase.group.GroupUseCases
import com.shindze.domain.usecase.group.GroupUseCasesImpl
import com.shindze.domain.usecase.meet.GetMeetsDataUseCase
import com.shindze.domain.usecase.meet.GetMeetsGuestUseCase
import com.shindze.domain.usecase.meet.MeetUseCases
import com.shindze.domain.usecase.meet.MeetUseCasesImpl
import com.shindze.domain.usecase.more.GetExtendedSettingsButtonUseCase
import com.shindze.domain.usecase.more.GetSettingsButtonUseCase
import com.shindze.domain.usecase.more.MoreScreenUseCases
import com.shindze.domain.usecase.more.MoreScreenUseCasesImpl
import com.shindze.domain.usecase.profile.GetProfileDataUseCase
import com.shindze.domain.usecase.profile.ProfileUseCases
import com.shindze.domain.usecase.profile.ProfileUseCasesImpl
import com.shindze.domain.usecase.profile.SetProfileDataUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {
    single<MeetUseCases> { MeetUseCasesImpl(get(), get()) }
    single<GroupUseCases> { GroupUseCasesImpl(get()) }
    single<ProfileUseCases> { ProfileUseCasesImpl(get(), get()) }
    single<MoreScreenUseCases> { MoreScreenUseCasesImpl(get(), get()) }


    factoryOf(::GetProfileDataUseCase)
    factoryOf(::SetProfileDataUseCase)
    factoryOf(::GetMeetsDataUseCase)
    factoryOf(::GetMeetsGuestUseCase)
    factoryOf(::GetGroupsDataUseCase)
    factoryOf(::GetSettingsButtonUseCase)
    factoryOf(::GetExtendedSettingsButtonUseCase)
}