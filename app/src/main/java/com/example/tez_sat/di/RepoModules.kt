package com.example.tez_sat.di

import com.example.tez_sat.ui.repository.Repository
import org.koin.core.module.Module
import org.koin.dsl.module

val repoModules:Module = module {
    single { Repository(get()) }
}