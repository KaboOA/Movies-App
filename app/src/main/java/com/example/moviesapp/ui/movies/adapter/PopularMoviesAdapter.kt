package com.example.moviesapp.ui.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.data.models.Result

import com.example.moviesapp.databinding.PopularItemBinding
import com.example.moviesapp.ui.movies.view.MoviesFragment

class PopularMoviesAdapter(val data: List<Result>, val movieClickListener: MoviesFragment) : ListAdapter<Result, PopularMoviesAdapter.MyViewHolder>(
    UserItemDiffCallback()
) {

    class MyViewHolder(val itemPopularBinding: PopularItemBinding) :
        RecyclerView.ViewHolder(itemPopularBinding.root) {
        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = PopularItemBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }
    interface MovieClickListener {
        fun onMovieClicked(movie: Result)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w500" + data.get(position).poster_path)
            .into(holder.itemPopularBinding.movieimg)
       holder.itemPopularBinding.movie= data.get(position)

        holder.itemPopularBinding.root.setOnClickListener{
            movieClickListener.onMovieClicked(data.get(position))
        }
    }

    class UserItemDiffCallback : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

    }
}