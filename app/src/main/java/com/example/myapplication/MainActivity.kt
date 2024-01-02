package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.helper.SharedPref
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var sharedPref: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPref = SharedPref(this)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleLogin()

        if (checkAvailableToken()) {
            handleTo(HomeActivity::class.java)
        }
    }

    private fun handleLogin() {
        val password = "admin1234"
        binding.apply {
            btnLogin.setOnClickListener {
                if (etPassword.text.toString() != password) {
                    handleVisibility(tvErrorPassword, true)
                } else {
                    handleVisibility(tvErrorPassword, false)
                    handleTo(HomeActivity::class.java)

                    val dummyToken = UUID.randomUUID().toString()
                    sharedPref.saveToken(dummyToken)

                }
            }

            btnRegister.setOnClickListener {
                handleTo(HomeActivity::class.java)
            }
        }
    }

    private fun checkAvailableToken(): Boolean {
        val token = sharedPref.getToken()
        return token.isNotEmpty()
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
