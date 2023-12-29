package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            handleRegister()
        }

    }

    private fun handleRegister() {
        with (binding) {
            val nameValue = etInputName.text.toString()
            val genderValue = etInputGender.text.toString()
            val addressValue = etInputAddress.text.toString()
            val ageValue = etInputAge.text.toString()

            if(nameValue.isEmpty() || genderValue.isEmpty() || addressValue.isEmpty() || ageValue.isEmpty()) {
                Toast.makeText(this@RegisterActivity, "Tolong isi dengan lengkap", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@RegisterActivity, ProfileActivity::class.java)
                intent.putExtra(KEY_NAME_VALUE, nameValue)
                intent.putExtra(KEY_GENDER_VALUE, genderValue)
                intent.putExtra(KEY_ADDRESS_VALUE, addressValue)
                intent.putExtra(KEY_AGE_VALUE, ageValue)
                startActivity(intent)
            }
        }
    }

    companion object {
        const val KEY_NAME_VALUE = "key_name_value"
        const val KEY_GENDER_VALUE = "key_gender_value"
        const val KEY_ADDRESS_VALUE = "key_address_value"
        const val KEY_AGE_VALUE = "key_age_value"
    }
}