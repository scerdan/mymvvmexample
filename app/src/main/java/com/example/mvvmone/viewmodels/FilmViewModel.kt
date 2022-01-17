package com.example.mvvmone.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.example.mvvmone.model.animeFilm
import com.example.mvvmone.model.animeFilmItem
import com.example.mvvmone.repository.FilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(private val repository: FilmRepository) : ViewModel() {

    private val _response = MutableLiveData<List<animeFilmItem>>()
    val responseFilms: MutableLiveData<List<animeFilmItem>>
        get() = _response

    init {
        getData()
    }

    private fun getData() =
        viewModelScope.launch(Dispatchers.IO) {
            repository.getfilms().let { response ->
                if (response.isSuccessful) {
                    _response.postValue(response.body())
                } else {
                    Log.d("tag", "peliculas Error: ${response.code()}")
                }
            }
        }
}