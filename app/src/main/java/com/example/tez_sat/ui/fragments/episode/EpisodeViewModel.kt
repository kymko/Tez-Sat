package com.example.tez_sat.ui.fragments.episode

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tez_sat.model.EpisodeModel
import com.example.tez_sat.ui.repository.Repository
import com.example.youtubeapi.core.network.Resource

class EpisodeViewModel(private val repository: Repository) : ViewModel() {

    fun getAllEpisodes():LiveData<Resource<EpisodeModel>>{
        return repository.getAllEpisodes()
    }
}
