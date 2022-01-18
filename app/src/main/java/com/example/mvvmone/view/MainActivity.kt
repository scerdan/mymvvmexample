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

    private val titleView: TextView
        get() = binding.titleView

    private val castTitle: TextView
        get() = binding.castTitle

    private val descriptionView: TextView
        get() = binding.descriptionView

    private val banner: ImageView
        get() = binding.bannerView

    private val avatarImg: ImageView
        get() = binding.avatarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnOne.setOnClickListener {
            viewModelFilm.responseFilms.observe(this, {
                val URL_IMG: String = it?.get(0)?.movie_banner.toString()
                val URL_IMG_TWO: String = it?.get(1)?.image.toString()

                titleView.text = it?.get(0)?.original_title
                castTitle.text = it?.get(0)?.title
                descriptionView.text = it?.get(0)?.description
                Log.e("score", it[0].rt_score)

                Glide.with(this).load(URL_IMG).into(banner)
                Glide.with(this).load(URL_IMG_TWO).into(avatarImg)
            })
        }
    }
}