package com.example.mvvmone.repository

import com.example.mvvmone.services.RetrofitClient
import com.example.mvvmone.services.WebService

class FilmRepository {
    private var apiService: WebService? = null

    init {
        apiService = RetrofitClient.getClient?.create(WebService::class.java)
    }

    suspend fun getfilms() = apiService?.getListFilms()
}