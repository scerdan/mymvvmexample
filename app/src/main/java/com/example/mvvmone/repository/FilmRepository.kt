package com.example.mvvmone.repository

import com.example.mvvmone.services.WebService
import javax.inject.Inject

class FilmRepository @Inject constructor(private val apiService: WebService) {
    suspend fun getfilms() = apiService.getListFilms()
}