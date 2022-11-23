package com.anuar81.ryckandmortytestapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.anuar81.ryckandmortytestapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initGraph()
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)
    }

    private fun initGraph() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHostFragment.let { _navHostFragment ->
            val graphInflater = _navHostFragment.navController.navInflater
            val navGraph = graphInflater.inflate(R.navigation.nav_graph)
            val naveController = _navHostFragment.navController
            val appBarConfiguration = AppBarConfiguration(naveController.graph)
            binding.toolbar
                .setupWithNavController(naveController, appBarConfiguration)
            naveController.setGraph(navGraph, intent.extras)
        }
    }
}
