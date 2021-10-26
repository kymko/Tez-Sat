package com.example.tez_sat.ui.fragments.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tez_sat.model.RickiModel
import com.example.tez_sat.ui.repository.Repository
import com.example.youtubeapi.core.network.Resource

class CharacterViewModel(private val repository: Repository) : ViewModel() {

    fun getAllCharacters():LiveData<Resource<RickiModel>>{
        val sortedList = repository.getAllCharacters()
        return repository.getAllCharacters()
    }
}