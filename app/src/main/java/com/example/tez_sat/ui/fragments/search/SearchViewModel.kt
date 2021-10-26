package com.example.tez_sat.ui.fragments.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tez_sat.model.RickiModel
import com.example.tez_sat.ui.repository.Repository
import com.example.youtubeapi.core.network.Resource

class SearchViewModel(private val repository: Repository) : ViewModel() {

    fun getFilterCharacter(name: String, status: String, gender: String): LiveData<Resource<RickiModel>> {
        return repository.getFilterCharacters(name, status, gender)
    }

}