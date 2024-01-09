package com.example.myapplication.utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.databinding.DialogLayoutBinding

class ConfirmationDialogUtil(private val context: Context) {

    fun showConfirmationDialog(
        title: String,
        icon: Int? = null,
        onConfirm: () -> Unit,
        onCancel: () -> Unit,
    ) {
        val dialogBuilder = AlertDialog.Builder(context)
        val alertDialog = dialogBuilder.create()

        // Inflate dialog_confirmation.xml layout using ViewBinding
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null)
        val binding = DialogLayoutBinding.bind(dialogView)

        // Set judul dan pesan
        binding.tvTitle.text = title

        if (icon != null) {
            binding.ivIconDialog.visibility = View.VISIBLE
            binding.ivIconDialog.setImageResource(icon)
        } else {
            binding.ivIconDialog.visibility = View.GONE
        }

        alertDialog.setView(dialogView)

        // Menambahkan fungsi onClickListener untuk tombol "Ya"
        binding.btnPositive.setOnClickListener {
            onConfirm.invoke() // Panggil aksi onConfirm
            alertDialog.dismiss()
        }

        // Menambahkan fungsi onClickListener untuk tombol "Tidak"
        binding.btnNegative.setOnClickListener {
            onCancel.invoke() // Panggil aksi onCancel
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}
