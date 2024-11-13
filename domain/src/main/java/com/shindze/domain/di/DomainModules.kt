package com.shindze.domain.di

import org.koin.dsl.module

val DomainModules = module { includes(useCaseModule) }

