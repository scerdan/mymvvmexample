package com.example.mvvmone.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.mvvmone.databinding.ActivityMainBinding
import com.example.mvvmone.repository.FilmRepository
import com.example.mvvmone.viewmodels.FilmViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModelFilm: FilmViewModel by viewModels()

    private val btnOne: Button
        get() = binding.button

    private val textOne: TextView
        get() = binding.textView

    private val imgView: ImageView
        get() = binding.imageView

    private val imgViewTwo: ImageView
        get() = binding.imageViewTwo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnOne.setOnClickListener {
            viewModelFilm.responseFilms.observe(this, {
                val URL_IMG: String = it?.get(0)?.image.toString()
                val URL_IMG_TWO: String = it?.get(1)?.image.toString()

                textOne.text = it?.get(0)?.title
                Log.e("IT", "$it\n")

                Glide.with(this).load(URL_IMG).into(imgView)
                Glide.with(this).load(URL_IMG_TWO).into(imgViewTwo)
            })
        }
    }
}