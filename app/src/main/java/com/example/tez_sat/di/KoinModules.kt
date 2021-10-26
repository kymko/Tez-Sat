package com.example.tez_sat.di

import org.koin.core.module.Module
import org.koin.dsl.module

val koinModules = listOf(
    viewModules,
    repoModules,
    retrofitModules
)