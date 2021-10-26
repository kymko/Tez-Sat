package com.example.tez_sat.ui.fragments.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tez_sat.model.LocationModel
import com.example.tez_sat.ui.repository.Repository
import com.example.youtubeapi.core.network.Resource

class LocationViewModel(private val repository: Repository) : ViewModel() {

    fun getAllLocations():LiveData<Resource<LocationModel>>{
        return repository.getAllLocation()
    }

}