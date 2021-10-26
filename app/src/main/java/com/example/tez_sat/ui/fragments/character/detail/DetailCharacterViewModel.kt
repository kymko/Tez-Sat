package com.example.tez_sat.ui.fragments.character.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tez_sat.model.RickiModel
import com.example.tez_sat.model.SingleModel
import com.example.tez_sat.ui.repository.Repository
import com.example.youtubeapi.core.network.Resource

class DetailCharacterViewModel(private val repository: Repository) : ViewModel() {

    fun getCharacterById(id:Int):LiveData<Resource<SingleModel>>{
        var sortedList = repository.getCharacterById(id).value
        return repository.getCharacterById(id)
    }
}