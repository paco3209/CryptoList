package com.example.cryptolist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController

import androidx.navigation.ui.setupWithNavController
import com.example.cryptolist.R

import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val navController = findNavController(R.id.newsNavHostFragment)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigation.setupWithNavController(navController)



        

    }
}