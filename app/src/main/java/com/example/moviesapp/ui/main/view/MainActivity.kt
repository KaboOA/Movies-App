package com.example.moviesapp.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val fragHost = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = fragHost.navController
        setupWithNavController(binding.bottomNav, navController)


    }
}
