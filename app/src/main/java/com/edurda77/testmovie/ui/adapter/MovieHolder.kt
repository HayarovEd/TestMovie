package com.edurda77.testmovie.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edurda77.testmovie.R
import com.edurda77.testmovie.databinding.ItemMovieBinding
import com.edurda77.testmovie.model.ModelMovie

class MovieHolder(
    private val binding: ItemMovieBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: ModelMovie) {
        binding.title.text = movie.titleMovie
        binding.description.text = movie.descriptionMovie
        Glide.with(this.itemView.context)
            .load(movie.posterMovie)
            .placeholder(R.drawable.ic_not_photo)
            .into(binding.poster)
    }
}