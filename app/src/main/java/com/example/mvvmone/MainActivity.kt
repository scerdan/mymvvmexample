package com.example.mvvmone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.mvvmone.repository.FilmRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {
    private val repository = FilmRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchFilmData()
    }

    private fun fetchFilmData() {

        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getfilms()
            val ver = response?.body()?.get(0)
            Log.e("200", ver.toString())

        }
    }
}