package com.example.myapplication.presentation

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.HomeMainActivityBinding
import com.example.myapplication.helper.SharedPrefHelper
import com.example.myapplication.presentation.home.HomeFragment
import com.example.myapplication.presentation.message.MessageFragment
import com.example.myapplication.utils.ConfirmationDialogUtil
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeMainActivity : AppCompatActivity() {

    private lateinit var binding: HomeMainActivityBinding

    @Inject
    lateinit var sharedPrefHelper: SharedPrefHelper

    private lateinit var confirmationDialogUtil: ConfirmationDialogUtil

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
                    showConfirmation()
                    return@OnNavigationItemSelectedListener false
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeMainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        confirmationDialogUtil = ConfirmationDialogUtil(this)


        binding.bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.navigationHome
        }
    }

    private fun showConfirmation() {
        val title = "Konfirmasi"
        val icon = R.drawable.ic_home_run

        confirmationDialogUtil.showConfirmationDialog(
            title,
            icon,
            onConfirm = {

            },
            onCancel = {

            }
        )
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder
            .setTitle("Apakah yakin")
            .setMessage("Ingin keluar dari livin ?")
            .setPositiveButton("Ya") { _: DialogInterface, _: Int ->
                logout()
            }.setNegativeButton("tidak") { _: DialogInterface, _: Int ->

            }

        val dialog = builder.create()
        dialog.show()
    }

    private fun logout() {
        sharedPrefHelper.clearDataPref()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
