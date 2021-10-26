package com.example.tez_sat.di

import com.example.tez_sat.ui.activities.main.MainViewModel
import com.example.tez_sat.ui.fragments.character.CharacterViewModel
import com.example.tez_sat.ui.fragments.character.detail.DetailCharacterViewModel
import com.example.tez_sat.ui.fragments.episode.EpisodeViewModel
import com.example.tez_sat.ui.fragments.location.LocationViewModel
import com.example.tez_sat.ui.fragments.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules: Module = module {
    viewModel { MainViewModel() }
    viewModel { CharacterViewModel(get()) }
    viewModel { EpisodeViewModel(get()) }
    viewModel { LocationViewModel(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { DetailCharacterViewModel(get()) }
}