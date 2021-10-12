package com.example.mvvmone.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.mvvmone.repository.FilmRepository
import kotlinx.coroutines.Dispatchers

class FilmViewModel(private val repository: FilmRepository) : ViewModel() {

    fun fetchData() = liveData(Dispatchers.IO) {
        try {
            emit(repository.getfilms()?.body())
            Log.e("200", "EMITIDO")
        } catch (e: Exception) {
            Log.e("ERROR LIVEDATA", e.message.toString())
        }
    }

//        CoroutineScope(Dispatchers.IO).launch {
//            val rta = repository.getfilms()?.body()
//
//            if (rta != null) {
//                for (i in 0 until rta.size) {
//                    Log.e("200", rta[i].title + " " + rta[i].description)
//                }
//            }
//        }

    class FilmViewModelFactory(private val repository: FilmRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(FilmRepository::class.java)
                .newInstance(repository)
        }

    }
}