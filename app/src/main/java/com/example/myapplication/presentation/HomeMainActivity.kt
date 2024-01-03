package com.example.myapplication.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.HomeMainActivityBinding
import com.example.myapplication.helper.SharedPref
import com.example.myapplication.presentation.home.HomeFragment
import com.example.myapplication.presentation.message.MessageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeMainActivity : AppCompatActivity() {

    private lateinit var binding: HomeMainActivityBinding
    private lateinit var sharedPref: SharedPref

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationHome -> {
                    replaceFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationPromo -> {
                    replaceFragment(PromoFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationMessage -> {
                    replaceFragment(MessageFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationSetting -> {
                    replaceFragment(SettingFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationLogout -> {
                    logout()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeMainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = SharedPref(this)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.navigationHome
        }
    }

    private fun logout() {
        sharedPref.clearDataPref()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
