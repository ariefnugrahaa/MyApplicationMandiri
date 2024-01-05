package com.example.myapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HistoryTransactionModel(
    val date: String,
    val titleTransaction : String,
    val subtitleTransaction: String,
    val balanceTransaction: String,
    val iconTransaction: Int,
    val statusTransaction: Int
) : Parcelable

enum class StatusTransaction(val value: Int) {
    Berhasil(1),
    Gagal(2),
    Pending(3)
}

enum class StatusTransfer(val value: String) {
    Credit("credit"),
    Debit("debit")
}
