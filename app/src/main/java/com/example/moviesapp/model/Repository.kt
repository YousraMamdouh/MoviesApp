package com.example.moviesapp.model

import com.example.moviesapp.network.RemoteService

class Repository(var remoteSource: RemoteService):RepoInterface{



    companion object{
        private var instance:Repository?=null
        fun getInstance(
            remoteSource: RemoteService
        ):Repository{
            return instance?: synchronized(this){
                val temp=Repository(
                    remoteSource
                )
                instance=temp
                temp
            }
        }
    }


    override suspend fun getAllMovies(): MovieResponse {
        return remoteSource.getAllMovies()
    }
}