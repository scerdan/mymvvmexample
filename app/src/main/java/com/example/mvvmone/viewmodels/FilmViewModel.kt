package com.example.mvvmone.viewmodels

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmone.model.animeFilm
import com.example.mvvmone.model.animeFilmItem
import com.example.mvvmone.repository.FilmRepository
import kotlinx.coroutines.launch

class FilmViewModel : ViewModel() {
    private val repository = FilmRepository()
    private val _filmItem = MutableLiveData<animeFilm>()

    suspend fun fetchData() {
        viewModelScope.launch {
            val response = repository.getfilms()
            for (i in 1 ..21) {
                val ver = response?.body()?.get(i)?.title
                Log.e("200", ver.toString())
            }
        }
    }
}
