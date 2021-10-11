package com.example.mvvmone.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmone.repository.FilmRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilmViewModel(private val repository: FilmRepository) : ViewModel() {

    val factsLive = MutableLiveData("CAMBIASTE DESDE LIVE DATA")

    init {
        fetchData()
    }

    private fun fetchData() {
        CoroutineScope(Dispatchers.IO).launch {
            val rta = repository.getfilms()?.body()

            if (rta != null) {
                for (i in 0 until rta.size) {
                    Log.e("200", rta[i].title)
                }
            }
        }
    }

    class FilmViewModelFactory(private val repository: FilmRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(FilmRepository::class.java).newInstance(repository)
        }

    }
}