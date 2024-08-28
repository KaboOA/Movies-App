package com.example.moviesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.databinding.MovieItemBinding

class MoviesAdapter (val data: List<MovieModel>,val movieClickListener: MovieClickListener) : ListAdapter<MovieModel, MoviesAdapter.MyViewHolder>(UserItemDiffCallback()) {

    class MyViewHolder(val itemMovieBinding: MovieItemBinding) :
        RecyclerView.ViewHolder(itemMovieBinding.root) {
        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MovieItemBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }
    interface MovieClickListener {
        fun onMovieClicked(movie: MovieModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemMovieBinding.movie= data.get(position)
        holder.itemMovieBinding.root.setOnClickListener{
            movieClickListener.onMovieClicked(data.get(position))
        }
    }

    class UserItemDiffCallback : DiffUtil.ItemCallback<MovieModel>() {
        override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem == newItem
        }

    }
}