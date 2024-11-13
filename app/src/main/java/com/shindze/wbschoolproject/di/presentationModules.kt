package com.shindze.wbschoolproject.di

import com.shindze.domain.repository.Repository
import com.shindze.repository.MockRepositoryImpl
import com.shindze.wbschoolproject.presentation.viewmodel.auth.number.NumberEnterViewModel
import com.shindze.wbschoolproject.presentation.viewmodel.auth.passcode.PasscodeEnterViewModel
import com.shindze.wbschoolproject.presentation.viewmodel.auth.profile.ProfileCreateViewModel
import com.shindze.wbschoolproject.presentation.viewmodel.group.GroupsViewModel
import com.shindze.wbschoolproject.presentation.viewmodel.group.detailed.GroupsDetailedViewModel
import com.shindze.wbschoolproject.presentation.viewmodel.meet.MeetsViewModel
import com.shindze.wbschoolproject.presentation.viewmodel.meet.detailed.MeetDetailedViewModel
import com.shindze.wbschoolproject.presentation.viewmodel.more.MoreScreenViewModel
import com.shindze.wbschoolproject.presentation.viewmodel.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val presentationModules = module {
    single<Repository> {
        MockRepositoryImpl()
    }
    viewModelOf(::NumberEnterViewModel)
    viewModelOf(::PasscodeEnterViewModel)
    viewModelOf(::ProfileCreateViewModel)
    viewModelOf(::MeetsViewModel)
    viewModelOf(::MeetDetailedViewModel)
    viewModelOf(::MoreScreenViewModel)
    viewModelOf(::ProfileViewModel)
    viewModelOf(::GroupsViewModel)
    viewModelOf(::GroupsDetailedViewModel)
}
