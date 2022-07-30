package com.edurda77.testmovie.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.testmovie.databinding.ActivityMainBinding
import com.edurda77.testmovie.model.ModelMovie
import com.edurda77.testmovie.model.StateMainActivity
import com.edurda77.testmovie.ui.adapter.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: MovieAdapter
    private val viewModel by viewModels<MovieViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getDataForShow(0)
        viewModel.movieData.observe(this) {
            when(it){
                is StateMainActivity.Loading->{
                    binding.recyclerViewMovie.isVisible=false
                    binding.progressBarFirst.isVisible=true
                }
                is StateMainActivity.Failure -> {
                    binding.recyclerViewMovie.isVisible = false
                    binding.progressBarFirst.isVisible = false
                    Toast.makeText(this, it.msg.message, Toast.LENGTH_SHORT).show()
                }
                is StateMainActivity.Success->{
                    binding.recyclerViewMovie.isVisible = true
                    binding.progressBarFirst.isVisible = false
                    initRecyclerview(it.data)
                    postAdapter.notifyDataSetChanged()
                }
                is StateMainActivity.Empty->{

                }
            }
        }
    }

    private fun initRecyclerview(list: List<ModelMovie>) {
        val recyclerView: RecyclerView = binding.recyclerViewMovie
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        recyclerView.adapter = MovieAdapter(list)
    }
}