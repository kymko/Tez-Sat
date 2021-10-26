package com.example.tez_sat.ui.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.tez_sat.model.EpisodeModel
import com.example.tez_sat.model.LocationModel
import com.example.tez_sat.model.RickiModel
import com.example.tez_sat.model.SingleModel
import com.example.tez_sat.remote.RickApi
import com.example.youtubeapi.core.network.Resource
import kotlinx.coroutines.Dispatchers

class Repository(private val rickApi: RickApi) {

    fun getAllCharacters(): LiveData<Resource<RickiModel>> = liveData(Dispatchers.IO) {

        emit(Resource.loading(null))
        val response = rickApi.getAllCharacters()
        emit(
            if (response.isSuccessful)
                Resource.success(response.body(), response.code())
            else
                Resource.error(response.message(), response.body(), response.code())
        )
    }

    fun getAllLocation(): LiveData<Resource<LocationModel>> = liveData(Dispatchers.IO) {

        emit(Resource.loading(null))

        val response = rickApi.getAllLocations()

        emit(
            if (response.isSuccessful)
                Resource.success(response.body(), response.code())
            else
                Resource.error(response.message(), response.body(), response.code())
        )
    }

    fun getAllEpisodes(): LiveData<Resource<EpisodeModel>> = liveData(Dispatchers.IO) {

        emit(Resource.loading(null))

        val response = rickApi.getAllEpisodes()

        emit(
            if (response.isSuccessful)
                Resource.success(response.body(), response.code())
            else
                Resource.error(response.message(), response.body(), response.code())
        )
    }

    fun getFilterCharacters(
        name: String,
        status: String,
        gender: String
    ): LiveData<Resource<RickiModel>> = liveData(Dispatchers.IO) {

        emit(Resource.loading(null))

        val response = rickApi.getFilterCharacter(name, status, gender)

        emit(
            if (response.isSuccessful)
                Resource.success(response.body(), response.code())
            else
                Resource.error(response.message(), response.body(), response.code())
        )

    }

    fun getCharacterById(id: Int): LiveData<Resource<SingleModel>> = liveData(Dispatchers.IO) {

        emit(Resource.loading(null))

        val response = rickApi.getCharacterById(id)

        emit(
            if (response.isSuccessful)
                Resource.success(response.body(), response.code())
            else
                Resource.error(response.message(), response.body(), response.code())
        )
    }
}