package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handleLogin()
    }

    private fun handleLogin() {
        val buttonLogin = findViewById<Button>(R.id.btnLogin)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val tvErrorPassword = findViewById<TextView>(R.id.tvErrorPassword)
        val btnRegister = findViewById<TextView>(R.id.btnRegister)
        val password = "admin1234"

        buttonLogin.setOnClickListener {
            if (etPassword.text.toString() != password) {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                handleVisibility(tvErrorPassword, true)
            } else {
                handleVisibility(tvErrorPassword, false)
                Toast.makeText(this, "Password ", Toast.LENGTH_SHORT).show()
                handleTo(HomeActivity::class.java)
            }
        }

        btnRegister.setOnClickListener {
            handleTo(RegisterActivity::class.java)
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
