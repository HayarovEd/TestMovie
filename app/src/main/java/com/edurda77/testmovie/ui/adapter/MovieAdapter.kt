package com.edurda77.testmovie.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.testmovie.databinding.ItemMovieBinding
import com.edurda77.testmovie.model.ModelMovie

class MovieAdapter  (private val list: List<ModelMovie>): RecyclerView.Adapter<MovieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieHolder(
            ItemMovieBinding.inflate(
                inflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie: ModelMovie = list[position]
        holder.bind(movie)
    }

    override fun getItemCount() = list.size
}