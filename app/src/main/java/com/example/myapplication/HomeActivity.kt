package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.RegisterActivity.Companion.KEY_NAME_VALUE
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.databinding.ActivityRegisterBinding

class HomeActivity: AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(KEY_NAME_VALUE)
        binding.tvName.text = name

    }
}