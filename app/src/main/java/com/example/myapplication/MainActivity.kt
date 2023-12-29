package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleLogin()
    }

    private fun handleLogin() {
        val password = "admin1234"
        binding.apply {
            btnLogin.setOnClickListener {
                if (etPassword.text.toString() != password) {
                    handleVisibility(tvErrorPassword, true)
                } else {
                    handleVisibility(tvErrorPassword, false)
                    handleTo(ProfileActivity::class.java)
                }
            }

            btnRegister.setOnClickListener {
                handleTo(RegisterActivity::class.java)
            }
        }
    }

    private fun handleTo(clazz: Class<*>) {
        val intent = Intent(this, clazz)
        startActivity(intent)
    }

    private fun handleVisibility(view:View, isVisible: Boolean) {
        view.isVisible = isVisible
    }

    companion object {
        const val NAME = "tetsetestestset"
        const val DELAY = 1000
    }
}
