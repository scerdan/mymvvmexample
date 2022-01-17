package com.example.mvvmone.services

import com.example.mvvmone.helper.Constants
import com.example.mvvmone.model.animeFilm
import retrofit2.Response
import retrofit2.http.GET

interface WebService {
    @GET(Constants.END_POINT)
    suspend fun getListFilms(): Response<animeFilm>
}