package com.example.mvvmone.services

import com.example.mvvmone.model.animeFilm
import retrofit2.Response
import retrofit2.http.GET

interface WebService {
    @GET("films")

    suspend fun getListFilms(): Response<animeFilm>
}