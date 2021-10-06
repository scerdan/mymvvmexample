package com.example.mvvmone.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.mvvmone.R
import com.example.mvvmone.repository.FilmRepository
import com.example.mvvmone.viewmodels.FilmViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val repository = FilmRepository()
    private val viewModelFilm: FilmViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchFilmData()
    }

    private fun fetchFilmData() {

        CoroutineScope(Dispatchers.IO).launch {
            viewModelFilm.fetchData()
        }
    }
}