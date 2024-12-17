package com.example.hw__3m4.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.hw__3m4.R
import com.example.hw__3m4.Utils.SharedPreferenceHelper

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var sharedPreferenceHelper: SharedPreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_fragment) as NavHostFragment

        navController = navHostFragment.navController

        sharedPreferenceHelper = SharedPreferenceHelper(this@MainActivity)

        if (!sharedPreferenceHelper.isOnBoardingComplete()) {
            sharedPreferenceHelper.setOnBoardingComplete(true)
        } else {
            navController.navigate(R.id.noteFragment)
        }
    }
}