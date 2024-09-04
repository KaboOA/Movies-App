package com.example.moviesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.moviesapp.databinding.FragmentMoreBinding
import com.example.moviesapp.ui.movies.adapter.NowPlayingMoviesAdapter
import com.example.moviesapp.ui.movies.adapter.PopularMoviesAdapter


class MoreFragment : Fragment() {
    private lateinit var binding : FragmentMoreBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false)


        return binding.root
    }
    }
