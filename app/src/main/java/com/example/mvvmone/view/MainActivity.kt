package com.example.mvvmone.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.mvvmone.databinding.ActivityMainBinding
import com.example.mvvmone.repository.FilmRepository
import com.example.mvvmone.viewmodels.FilmViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModelFilm: FilmViewModel by viewModels {
        FilmViewModel.FilmViewModelFactory(
            repository
        )
    }

    private val repository = FilmRepository()

    private val btnOne: Button
        get() = binding.button

    private val textOne: TextView
        get() = binding.textView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnOne.setOnClickListener {
            viewModelFilm.factsLive.observe(this, Observer {
                textOne.text = it
            })
        }
    }
}